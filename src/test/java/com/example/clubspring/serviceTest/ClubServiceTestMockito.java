package com.example.clubspring.serviceTest;

import com.example.clubspring.models.club.Club;
import com.example.clubspring.models.clubDto.ClubDto;
import com.example.clubspring.repositories.ClubRepository;
import com.example.clubspring.services.impl.ClubServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClubServiceTestMockito {

    @Mock
    private ClubRepository clubRepository;

    @InjectMocks
    private ClubServiceImpl clubService;

//    private Club club;
//
//    @BeforeEach
//    void setUp() {
//        club = Club.builder()
//                .id(1L)
//                .title("Football Club")
//                .photoUrl("photo.jpg")
//                .content("Best football club")
//                .build();
//    }

//    @Test
//    void testFindClubById() {
//
//        // Given (Arrange) — подготовка данных и мока
//        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));
//
//        // When (Act) — вызов тестируемого метода
//        ClubDto foundClub = clubService.findClubByID(1L);
//
//        // Then (Assert) — проверка результата
//        assertNotNull(foundClub, "Клуб не должен быть null");
//        assertEquals("Football Club", foundClub.getTitle(), "Название клуба должно совпадать");
//
//        // Проверяем, что метод findById вызвался 1 раз
//        verify(clubRepository, times(1)).findById(1L);
//    }

    @Test
    public void ClubServicesTest_CreateClub_ReturnsClubIsNotEmpty(){

        //Arrange
        Club club = Club.builder()
                .title("Football Club")
                .content("Best football club")
                .build();
        ClubDto clubDto = ClubDto.builder().id(1L).title("Football Club").content("Best football club").build();

        when(clubRepository.save(Mockito.any(Club.class))).thenReturn(club);

        //Act
        ClubDto savedClubDto = clubService.createClub(clubDto);

        //Assert
        Assertions.assertThat(savedClubDto).isNotNull();
        verify(clubRepository, times(1)).save(Mockito.any(Club.class));
    }

    @Test
    public void ClubRepository_findAllCubs_ReturnsClubsIsNotEmpty(){

        //Arrange
        Club club1 = Club.builder()
                .title("Football Club")
                .content("Best football club")
                .build();
        Club club2 = Club.builder()
                .title("Football Club")
                .content("Best football club")
                .build();

        List<Club> clubs = Arrays.asList(club1, club2);

        when(clubRepository.findAll()).thenReturn(clubs);

        //Act
        List<ClubDto> clubDtos = clubService.findAllCubs();

        //Assert
        Assertions.assertThat(clubDtos).isNotNull();
        Assertions.assertThat(clubDtos).hasSize(2);
        verify(clubRepository, times(1)).findAll();
    }

    @Test
    public void ClubServicesTest_findClubByID_ReturnClub(){


        //Arrange
        Club club = Club.builder()
                .title("Football Club")
                .content("Best football club")
                .build();

        when(clubRepository.findById(1L)).thenReturn(Optional.ofNullable(club));

        //Act
        ClubDto savedClubDto = clubService.findClubByID(1);

        //Assert
        Assertions.assertThat(savedClubDto).isNotNull();
        verify(clubRepository, times(1)).findById(1L);
    }
}
