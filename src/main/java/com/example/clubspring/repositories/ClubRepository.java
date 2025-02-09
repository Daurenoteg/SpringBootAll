package com.example.clubspring.repositories;

import com.example.clubspring.models.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
