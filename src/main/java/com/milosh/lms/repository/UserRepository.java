package com.milosh.lms.repository;

import com.milosh.lms.dto.UserResponseDTO;
import com.milosh.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    UserResponseDTO findByFirstNameAndLastName(String firstName, String lastName);
}
