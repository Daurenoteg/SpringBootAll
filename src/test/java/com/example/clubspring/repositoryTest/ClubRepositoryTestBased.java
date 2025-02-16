package com.example.clubspring.repositoryTest;

import com.example.clubspring.models.club.Club;
import com.example.clubspring.repositories.ClubRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ClubRepositoryTestBased {

    @Autowired
    private ClubRepository clubRepository;

    @Test
    public void ClubRepositoryTest_SaveClub(){

        //Arrange
        Club club = Club.builder()
                .title("Football Club")
                .photoUrl("photo.jpg")
                .content("Best football club")
                .build();

        //Act
        Club savedClub = clubRepository.save(club);

        //Assert
        Assertions.assertThat(savedClub).isNotNull();
        Assertions.assertThat(savedClub.getId()).isGreaterThan(0);
    }

    @Test
    public void ClubRepositoryTest_FindById_ReturnClub(){

        //Arrange
        Club club = Club.builder()
                .title("Football Club")
                .photoUrl("photo.jpg")
                .content("Best football club")
                .build();

        //Act
        clubRepository.save(club);
        Club findedClub = clubRepository.findById(club.getId()).get();

        //Assert
        Assertions.assertThat(findedClub).isNotNull();
    }
}
