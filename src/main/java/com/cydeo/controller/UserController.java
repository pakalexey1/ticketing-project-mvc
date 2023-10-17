package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());

        userService.save(user);

//        model.addAttribute("users", userService.findAll());

        //Commented out section is not needed because the redirect function below loads the original empty-form create page.

        return "redirect:user/create"; //user attribute, role attribute, users to populate table
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){


        //what attributes need to be defined?

        //1. user attribute
        //2. roles
        //3. users

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(UserDTO user){

        userService.update(user);

        return "redirect:/user/create";
    }

}
