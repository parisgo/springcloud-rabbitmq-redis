package org.paris8.sctestapp.controller;

import org.paris8.sctestapp.model.User;
import org.paris8.sctestapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(User user) {
        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(User user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/getById")
    @ResponseBody
    public User getById(Long id){
        try {
            return userService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User();
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(){
        try {
            return userService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<User>();
    }
}
