package com.example.graphQl.repositories;

import com.example.graphQl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
