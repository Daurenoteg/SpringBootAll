package com.example.clubspring.services.impl;

import com.example.clubspring.models.club.Club;
import com.example.clubspring.models.clubDto.ClubDto;
import com.example.clubspring.repositories.ClubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService{


    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) { this.clubRepository = clubRepository;}

    @Override
    public List<ClubDto> findAllCubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream()
                .map(this::mapToClubToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubByID(long clubId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new EntityNotFoundException("Клуб с ID " + clubId + " не найден"));
        return mapToClubToDto(club);
    }

    @Override
    public void deleteClub(long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapDtoToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public ClubDto createClub(ClubDto clubDto) {
        if (clubDto == null) {
            throw new IllegalArgumentException("ClubDto cannot be null");
        }
        Club club = mapDtoToClub(clubDto);
        Club savedClub = clubRepository.save(club);
        return mapToClubToDto(savedClub);
}



    private Club mapDtoToClub(ClubDto clubDto) {
        return Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
    }

    private ClubDto mapToClubToDto(Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }
}
