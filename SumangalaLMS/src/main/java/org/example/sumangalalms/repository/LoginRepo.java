package org.example.sumangalalms.repository;

import org.example.sumangalalms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<User, String> {
    User findByUserIdAndPassword(String userId, String Password);
}

