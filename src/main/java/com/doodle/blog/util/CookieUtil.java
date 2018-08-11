package com.doodle.blog.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.doodle.blog.constant.WebConstant.USERS_IN_COOKIE;
import static com.doodle.blog.util.EncryptUtil.aesEncode;

public class CookieUtil {

    public static void storeUserInCookie(String key, HttpServletResponse response, long userId) throws Exception {
        Cookie cookie = new Cookie(USERS_IN_COOKIE, aesEncode(key, String.valueOf(userId)));
        cookie.setPath("/");
        cookie.setMaxAge(30 * 60);
        cookie.setSecure(false);
        response.addCookie(cookie);
    }

    public static Long getUserIdFromCookie(HttpServletRequest request) {
        return null;
    }
}
