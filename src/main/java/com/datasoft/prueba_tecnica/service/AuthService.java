package com.datasoft.prueba_tecnica.service;

import com.datasoft.prueba_tecnica.models.dto.requets.LoginRequest;
import com.datasoft.prueba_tecnica.models.dto.requets.RegisterRequest;
import com.datasoft.prueba_tecnica.models.dto.response.AuthResponse;
import com.datasoft.prueba_tecnica.models.entities.UserEntity;
import com.datasoft.prueba_tecnica.repositories.UserRepository;
import com.datasoft.prueba_tecnica.security.JwtService;
import com.datasoft.prueba_tecnica.utils.exceptions.InvalidCredentialsException;
import com.datasoft.prueba_tecnica.utils.exceptions.UserAlreadyExistsException;
import com.datasoft.prueba_tecnica.utils.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("El username ya está en uso: " + request.getUsername());
        }
        UserEntity user = userMapper.toEntity(request);
        user.setPasswd(passwordEncoder.encode(request.getPassword()));
        user.setState("ACT");
        userRepository.save(user);
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return AuthResponse.builder()
                .token(jwtService.generateToken(userDetails))
                .user(userMapper.toResponse(user))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Credenciales inválidas");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        UserEntity user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        return AuthResponse.builder()
                .token(jwtService.generateToken(userDetails))
                .user(userMapper.toResponse(user))
                .build();
    }
}
