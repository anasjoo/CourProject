package com.LDS.linedata.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService
{
    @Autowired
    private  UserRepository userRepository ;

    @Autowired
    private EmailService emailService;
    public User  getUser(Integer id)
    {
        Optional<User> users = this.userRepository.findById(id);
       return users.orElse(new User()) ;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   /* public User createUser(User user) {
        return userRepository.save(user);
    }*/

    /* public User createUser(User user) {
        User createdUser = userRepository.save(user);
        try {
            emailService.sendEmail(user.getEmail(), "Welcome to Line Data", "Your account has been created.");
        } catch (Exception e) {

            System.err.println("Failed to send email: " + e.getMessage());

        }
        return createdUser;
    }*/
    public User createUser(User user) {
        User createdUser = userRepository.save(user);
        try {
            System.out.println("Attempting to send email to: " + user.getEmail());
            emailService.sendEmail(user.getEmail(), "Welcome to Line Data", "Your account has been created.");
            System.out.println("Email sent successfully to: " + user.getEmail());
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
        return createdUser;
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        return userRepository.save(user);
    }

}


