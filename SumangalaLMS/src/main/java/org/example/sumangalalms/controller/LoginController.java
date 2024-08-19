package org.example.sumangalalms.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.sumangalalms.model.User;
import org.example.sumangalalms.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    private LoginRepo loginRepo;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String userId = credentials.get("userId");
        String password = credentials.get("password");

        User user = loginRepo.findByUserIdAndPassword(userId,password);

        if (user != null) {
            return ResponseEntity.ok(((User) user).getRole().toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User_id or Password");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/viewAllUser")
    @ResponseBody
    public ResponseEntity<List<User>> listUser() {
        Iterable<User> userList = loginRepo.findAll();
        return ResponseEntity.ok((List<User>) userList);
    }

}
