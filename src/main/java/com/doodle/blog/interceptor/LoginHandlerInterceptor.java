package com.doodle.blog.interceptor;

import com.doodle.blog.cache.MyCache;
import com.doodle.blog.exception.AuthException;
import com.doodle.blog.model.User;
import com.doodle.blog.service.IUserService;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Objects;

import static com.doodle.blog.constant.WebConstant.*;
import static com.doodle.blog.util.CookieUtil.*;

@Component
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        User user = null;
        HttpSession session = request.getSession();
        if (!Objects.isNull(session)) {
            user = (User) session.getAttribute(LOGIN_SESSION_KEY);
        }

        if (Objects.isNull(user)) {
            Long userId = getUserIdFromCookie(request);
            if (!Objects.isNull(userId)) {
                try {
                    user = userService.findUser(userId);
                    request.getSession().setAttribute(LOGIN_SESSION_KEY, user);
                } catch (AuthException e) {
                    log.info("user doesn't exist with userid = {}", userId);
                }
            }

            if (!requestURI.startsWith(SIGN_UP_PATH) && !requestURI.startsWith(SIGN_IN_PATH)) {
                response.sendRedirect(request.getContextPath() + SIGN_IN_PATH);
                return false;
            }
        }

        preventCSRF(request);

        return true;
    }

    private void preventCSRF(HttpServletRequest request) {
        //set csrf to prevent attack
        Cache<String, Object> cache = (Cache<String, Object>) request.getAttribute(CSRF_PREVENT);
        if (Objects.isNull(cache)) {
            cache = MyCache.getInstance().buildCache(20 * 60);
            request.getSession().setAttribute(CSRF_PREVENT, cache);
        }

        // Generate the salt and store it in the users cache
        String salt = RandomStringUtils.random(20, 0, 0, true, true, null,
                new SecureRandom());
        cache.put(salt, true);

        request.setAttribute(CSRF_PREVENT, salt);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
