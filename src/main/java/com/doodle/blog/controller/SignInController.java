package com.doodle.blog.controller;

import com.doodle.blog.config.EncryptConfig;
import com.doodle.blog.exception.AuthException;
import com.doodle.blog.logic.RestResponse;
import com.doodle.blog.model.User;
import com.doodle.blog.service.IUserService;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import static com.doodle.blog.constant.ConfigConstant.*;
import static com.doodle.blog.constant.WebConstant.*;
import static com.doodle.blog.util.CookieUtil.*;

@Controller
@RequestMapping("/auth")
@Slf4j
public class SignInController extends BaseController {

    @Resource
    private IUserService userService;

    @Autowired
    private EncryptConfig encryptConfig;

    private Cache<String, Object> signInCache = cache.buildCache(2 * 60);

    @PostMapping("/sign_in")
    public RestResponse signIn(@RequestParam String userName, @RequestParam String password,
                               @RequestParam(required = false) String rememberMe, HttpServletRequest request,
                               HttpServletResponse response) {
        Integer tryCount = (Integer) signInCache.getIfPresent(RETRY_COUNT);

        try {
            User user = userService.login(userName, password);
            request.getSession().setAttribute(LOGIN_SESSION_KEY, user);

            if (!StringUtils.isEmpty(rememberMe)) {
                String aesKey = encryptConfig.getAes();
                storeUserInCookie(aesKey, response, user.getUserId());
            }
        } catch (AuthException e) {
            tryCount = tryCount == null ? 1 : tryCount + 1;

            if (tryCount == MAX_RETRY) {
                return RestResponse.fail("重试次数达到上限，请在两分钟之后再次尝试.");
            }
            signInCache.put(RETRY_COUNT, tryCount);
        } catch (Exception e) {
            log.error("store user in cookie error");
            return RestResponse.fail();
        }

        return RestResponse.success();
    }
}
