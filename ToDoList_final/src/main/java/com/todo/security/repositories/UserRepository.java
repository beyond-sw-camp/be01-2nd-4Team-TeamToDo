package com.todo.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByNickname(String nickname);
    Optional<User> findByLoginId(String loginId);
}