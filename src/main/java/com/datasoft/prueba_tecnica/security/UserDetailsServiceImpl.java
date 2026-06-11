package com.datasoft.prueba_tecnica.security;

import com.datasoft.prueba_tecnica.models.entities.UserEntity;
import com.datasoft.prueba_tecnica.repositories.UserRepository;
import com.datasoft.prueba_tecnica.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado: " + username));
        return User.builder()
                .username(user.getUsername())
                .password(user.getPasswd())
                .disabled(!"ACT".equals(user.getState()))
                .authorities(List.of())
                .build();
    }
}
