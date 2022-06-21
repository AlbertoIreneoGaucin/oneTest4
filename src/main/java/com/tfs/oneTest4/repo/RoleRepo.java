

package com.tfs.oneTest4.repo;

import com.tfs.oneTest4.domain.Role;

import com.tfs.oneTest4.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface RoleRepo extends MongoRepository<Role, String> {

    Role findByRole(String role);
    //Optional<Student> findStudentByEmail(String email);
}


