package com.terryx.controller;

import com.terryx.model.UserEntity;
import com.terryx.model.VSimpleUser;
import com.terryx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 页面控制
 * Created by xueta on 2016/4/13 17:44.
 */
@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String usersPage() {
        return "users";
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detailPage(@PathVariable("id") Integer userId, ModelMap modelMap) throws Exception {
        UserEntity userEntity = userService.findById(userId);
        modelMap.addAttribute("name", userEntity.getName());
        modelMap.addAttribute("screenName", userEntity.getScreenName());
        modelMap.addAttribute("description", userEntity.getDescription());

        String imgFileName = this.getImgFileName(userEntity.getProfileImageUrl());
        modelMap.addAttribute("imgFileName", imgFileName);

        Map<Integer, Double> resultMap = userService.getTopRecommendUserIds(userId, 10, 8);
        List<VSimpleUser> vUsers = new ArrayList<VSimpleUser>();

        for (Map.Entry<Integer, Double> entry : resultMap.entrySet()) {
            UserEntity tempUser = userService.findById(entry.getKey());
            VSimpleUser tVUser = new VSimpleUser();
            tVUser.setName(tempUser.getName());
            tVUser.setDescription(tempUser.getDescription());
            tVUser.setScreenName(tempUser.getScreenName());
            tVUser.setUserId(tempUser.getUserId());
            tVUser.setProfileImageUrl(getImgFileName(tempUser.getProfileImageUrl()));
            vUsers.add(tVUser);
        }
        modelMap.addAttribute("SimilarUsers", vUsers);
        return "detail";
    }

    /**
     * 获取头像图片文件名
     *
     * @param imgUrl 原路径
     * @return 文件名
     */
    private String getImgFileName(String imgUrl) {
        String[] imgFileNames = imgUrl.split("/");
        return imgFileNames[imgFileNames.length - 1];
    }
}
