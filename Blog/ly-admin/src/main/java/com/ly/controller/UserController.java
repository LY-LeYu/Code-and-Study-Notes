package com.ly.controller;

import com.ly.domain.ResponseResult;
import com.ly.domain.entity.User;
import com.ly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseResult getUserPage(Integer pageNum, Integer pageSize, String userName, String status,String phoneNumber) {
        return userService.getUserPage(pageNum,pageSize,userName,phoneNumber,status);
    }

    @PostMapping
    public ResponseResult addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public ResponseResult getUserById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PutMapping
    public ResponseResult updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody Map<String, Long> map) {
        return userService.changeStatus(map);
    }

    @DeleteMapping("/{userId}")
    public ResponseResult deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
