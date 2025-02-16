package com.example.clubspring.models.clubDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Название клуба не может быть пустым")
    @Size(min = 3, max = 50, message = "Название клуба должно быть от 3 до 50 символов")
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
