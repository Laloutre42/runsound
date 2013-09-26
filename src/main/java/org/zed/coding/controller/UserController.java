package org.zed.coding.controller;

import org.resthub.web.controller.ServiceBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zed.coding.model.User;
import org.zed.coding.service.jpa.IUserService;

import javax.inject.Inject;
import javax.inject.Named;


@Controller
@RequestMapping(value = "/api/user")
public class UserController extends ServiceBasedRestController<User, Integer, IUserService> {

    @Override
    @Inject
    @Named("userService")
    public void setService(IUserService service) {
        this.service = service;
    }

}
