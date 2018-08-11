package com.doodle.blog.constant;

import org.springframework.stereotype.Component;

@Component
public class WebConstant {

    public static String LOGIN_SESSION_KEY = "LOGIN_USER";

    public static String CSRF_PREVENT = "_csrf";

    public static String SIGN_IN_PATH = "/auth/sign_in";

    public static String SIGN_UP_PATH = "/auth/sign_up";

    public static String RETRY_COUNT = "RETRY_COUNT";

    public static String USERS_IN_COOKIE = "store_user";
}
