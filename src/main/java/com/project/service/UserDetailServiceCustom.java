package com.project.service;

import com.project.model.Role;
import com.project.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceCustom implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final com.project.model.User user =
                userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return User.builder()
                .username(username)
                .password(user.getPassword())
                .roles(prepareRoles(user.getRoles()))
                .build();
    }

    private String[] prepareRoles(List<Role> roles) {

        return roles
                .stream()
                .map(Role::getName)
                .toArray(String[]::new);
    }
}
