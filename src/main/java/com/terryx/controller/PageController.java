package com.terryx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xueta on 2016/4/13 17:44.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/user")
    public String usersPage() {
        return "users";
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detailPage(Integer userId, ModelMap modelMap) {

        return "detail";
    }
}
