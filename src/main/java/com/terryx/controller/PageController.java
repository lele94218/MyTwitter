package com.terryx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xueta on 2016/4/13 17:44.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/hehe")
    public String usersPage() {
        return "users";
    }
}
