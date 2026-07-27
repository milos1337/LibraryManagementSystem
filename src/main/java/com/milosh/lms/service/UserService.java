package com.milosh.lms.service;

import com.milosh.lms.dto.CreateUserDTO;
import com.milosh.lms.dto.UpdateUserDTO;
import com.milosh.lms.dto.UserResponseDTO;
import com.milosh.lms.entity.User;
import com.milosh.lms.exception.NoSuchUserException;
import com.milosh.lms.mapper.UserMapper;
import com.milosh.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public User getUserEntity(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchUserException("No such user found."));
    }

    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        return mapper.toDTO(getUserEntity(id));
    }

    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {

        User user = mapper.toEntity(createUserDTO);

        userRepository.save(user);

        return mapper.toDTO(user);
    }

    public UserResponseDTO updateUser(Long id, UpdateUserDTO updateUserDTO) {

        User user = getUserEntity(id);

        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());
        user.setEmail(updateUserDTO.getEmail());
        user.setEnabled(updateUserDTO.isEnabled());

        return mapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {

        User user = getUserEntity(id);

        userRepository.delete(user);
    }
}
