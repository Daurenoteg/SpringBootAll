package services.impl;

import jakarta.persistence.EntityNotFoundException;
import models.club.Club;
import models.clubDto.ClubDto;
import org.springframework.stereotype.Service;
import repositories.ClubRepository;

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
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    private Club mapToClub(ClubDto clubDto) {
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
