package com.intellij.terarosa.repository;

import com.intellij.terarosa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
