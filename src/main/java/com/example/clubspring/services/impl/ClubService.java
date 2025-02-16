package com.example.clubspring.services.impl;

import com.example.clubspring.models.club.Club;
import com.example.clubspring.models.clubDto.ClubDto;

import java.util.List;

public interface ClubService {

    List<ClubDto> findAllCubs();

    Club saveClub(Club club);

    ClubDto findClubByID(long clubId);

    void deleteClub(long clubId);

    void updateClub(ClubDto clubDto);

    ClubDto createClub(ClubDto clubDto);
}
