package com.example.clubspring.controllers;

import com.example.clubspring.models.clubDto.ClubDto;
import com.example.clubspring.services.impl.ClubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
@Tag(name = "Club API", description = "API для управления клубами")
public class ClubRestController {

    private final ClubService clubService;

    public ClubRestController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    @Operation(
            summary = "Получить список клубов",
            description = "Возвращает список всех клубов в системе"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список клубов успешно получен",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClubDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера"
            )
    })
    public List<ClubDto> listClubs() {
        return clubService.findAllCubs();
    }
}
