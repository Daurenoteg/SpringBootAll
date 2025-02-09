package services.impl;

import models.clubDto.ClubDto;
import models.club.Club;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClubService {

    List<ClubDto> findAllCubs();

    Club saveClub(Club club);

    ClubDto findClubByID(long clubId);

    void updateClub(ClubDto clubDto);
}
