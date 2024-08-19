package org.example.sumangalalms.controller;

import org.example.sumangalalms.model.User;
import org.example.sumangalalms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserRepo userRepo;

    //view user details function
   @GetMapping("/getUsers")
    public List<User> getUsers(){
       return userRepo.findAll();
   }

   //create new user function
   @PostMapping("/createUser")
    public ResponseEntity<User> newUser(@RequestBody User newUser) {
       try {
           User savedUser = userRepo.save(newUser);

           System.out.println(" New User Successfully Added !");
           return ResponseEntity.ok(savedUser);
       } catch (Exception e) {

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }

   //update user details function
   @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable("userId") String userId) {

       try {
           Optional<User> existingUserOptional = userRepo.findById(userId);
           if (existingUserOptional.isPresent()) {
               User existingUser = existingUserOptional.get();
               existingUser.setFName(updateUser.getFName());
               existingUser.setLName(updateUser.getLName());
               existingUser.setGender(updateUser.getGender());
               existingUser.setAddress_L1(updateUser.getAddress_L1());
               existingUser.setAddress_L2(updateUser.getAddress_L2());
               existingUser.setDOB(updateUser.getDOB());
               existingUser.setEmail(updateUser.getEmail());
               existingUser.setPassword(updateUser.getPassword());
               existingUser.setPro_pic(updateUser.getPro_pic());

               User updatedUser = userRepo.save(existingUser);
               return ResponseEntity.ok(updatedUser);
           } else {
               return ResponseEntity.notFound().build();
           }
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }

   }

   //delete user function
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable ("userId") String userId){

       try{
           Optional<User> userOptional = userRepo.findById(userId);
           if(userOptional.isPresent()){
               userRepo.deleteById(userId);
               return ResponseEntity.ok(" User deleted Successfully!");

           }else {
               return ResponseEntity.notFound().build();
           }
       }catch (Exception e)
       {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting user: "+e.getMessage());
       }
    }


}

