package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/user/create")
    public String getMethodName() {

        User user = new User();
        user.setName("Minh");
        user.setEmail("hehe@gmail.com");
        user.setPassword("xxxxxx");

        this.userService.handleCreateUser(user);

        return "create user";
    }
    
}
