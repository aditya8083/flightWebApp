package com.coviam.controller.user;

import com.coviam.entity.userEntity.UserDetail;
import com.coviam.service.UserManager;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {

    @Autowired UserManager userManager;


    @RequestMapping(value = "/user/getUserDetails", method = RequestMethod.GET)
    public String getUserDetails(HttpServletRequest request) {
        System.out.println("get user Details");
        String getUser = userManager.getUserDetails(request);
        return getUser;
    }

    @RequestMapping(value = "/user/saveUserDetails", method = RequestMethod.POST)
    public String saveUserDetails(@RequestBody UserDetail userDetail) {
        System.out.println("save User Details");
        userManager.saveUserDetails(userDetail);
        return "User Data Saved correctly";
    }

    @RequestMapping(value = "/user/updateUserDetails", method = RequestMethod.PUT)
    public String updateUserDetails(@RequestBody UserDetail userDetail) {
        System.out.println("Update User Details");
        userManager.updateUserDetails(userDetail);
        return "User Data updated correctly";
    }


}
