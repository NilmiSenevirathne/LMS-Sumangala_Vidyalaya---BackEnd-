package org.example.sumangalalms.repository;

import org.example.sumangalalms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, String>{
    User findByUserIdAndPassword(String userId,String Password );
}
