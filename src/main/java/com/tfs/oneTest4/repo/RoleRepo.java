package com.tfs.oneTest4.repo;

import com.tfs.oneTest4.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
