package com.instabytes.instabytes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instabytes.instabytes.dto.UserDTO;
import com.instabytes.instabytes.entities.User;
import com.instabytes.instabytes.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    public UserDTO findById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
    
}
