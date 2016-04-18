package com.terryx.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.terryx.jsonview.Views;
import com.terryx.model.PageCriteria;
import com.terryx.model.UserEntity;
import com.terryx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xueta on 2016/4/12 15:20.
 */
@RestController
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Page<UserEntity> getUsersByPage(@RequestBody PageCriteria page) {
        Sort sort = new Sort(Sort.Direction.ASC, "userId");
        Pageable pageable = new PageRequest(page.getPage(), page.getSize(), sort);
        return userService.findAll(pageable);
    }


    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users_1", method = RequestMethod.POST)
    public Page<UserEntity> getUsersByPage_1(@RequestParam(value = "page", defaultValue = "0") Integer page) {

        Sort sort = new Sort(Sort.Direction.ASC, "userId");
        Pageable pageable = new PageRequest(page, 15, sort);
        return userService.findAll(pageable);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/uu")
    public UserEntity getUser() {
        UserEntity userEntity = userService.findById(1095);
        System.out.println(userEntity.getName());
        return userEntity;
    }

}
