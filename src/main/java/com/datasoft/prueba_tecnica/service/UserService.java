package com.datasoft.prueba_tecnica.service;

import com.datasoft.prueba_tecnica.models.dto.response.UserResponse;
import com.datasoft.prueba_tecnica.models.entities.UserEntity;
import com.datasoft.prueba_tecnica.repositories.UserRepository;
import com.datasoft.prueba_tecnica.utils.exceptions.UserNotFoundException;
import com.datasoft.prueba_tecnica.utils.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
        return userMapper.toResponse(user);
    }
}
