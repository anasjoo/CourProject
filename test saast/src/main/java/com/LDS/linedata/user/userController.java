package com.LDS.linedata.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/UserController")
public class userController {
    @Autowired
     private  userService UserService ;
@GetMapping("/get_user")
    public User getUser(@RequestParam Integer id)
    {
        return UserService.getUser(id);
    }
    @GetMapping("/employees")
    public List<User> getAllUser(){
        return (List<User>) UserService.getAllUsers();
    }

    @PostMapping("/create_user")
    public User createUser(@RequestBody User user) {
        return UserService.createUser(user);
    }

    @DeleteMapping("/delete_user")
    public void deleteUser(@RequestParam Integer id) {
            UserService.deleteUser(id);
    }

    @PutMapping("/update_user")
    public User updateUser(@RequestParam Integer id, @RequestBody User userDetails) {
        return UserService.updateUser(id, userDetails);
    }
}
