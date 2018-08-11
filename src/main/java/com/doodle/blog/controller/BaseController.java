package com.doodle.blog.controller;

import com.doodle.blog.cache.MyCache;

public abstract class BaseController {

    protected MyCache cache = MyCache.getInstance();
}
