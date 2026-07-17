package com.milosh.lms.service;

import com.milosh.lms.dto.UserDTO;
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

    public User getUserEntity(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchUserException("No such user found."));
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    public UserDTO getUserById(Long id) {

        User user = getUserEntity(id);

        return UserMapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO userDTO) {

        User user = UserMapper.toEntity(userDTO);

        userRepository.save(user);

        return UserMapper.toDTO(user);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User user = getUserEntity(id);

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(userDTO.isEnabled());

        return UserMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {

        User user = getUserEntity(id);

        userRepository.delete(user);
    }
}
