package com.BlogApplication.BlogApplication.repo;

import com.BlogApplication.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
