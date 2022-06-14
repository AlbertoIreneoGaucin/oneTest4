package com.tfs.oneTest4.repo;

import com.tfs.oneTest4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
