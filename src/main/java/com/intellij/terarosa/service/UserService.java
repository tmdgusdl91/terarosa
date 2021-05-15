package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.User;
import com.intellij.terarosa.repository.UserRepository;
import com.intellij.terarosa.repository.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(UserDto userDto) throws Exception {
        try {
            User user = userDto.toEntity();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(true);
            userRepository.save(user);
        } catch (Exception e) {
            log.error("error ::::::: " + e.toString());
            throw new Exception();
        }
    }
}
