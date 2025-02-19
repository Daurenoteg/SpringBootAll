package com.example.clubspring.controllers;

import com.example.clubspring.models.club.Club;
import com.example.clubspring.models.clubDto.ClubDto;
import com.example.clubspring.services.impl.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {

private ClubService clubService;

@Autowired
private ClubController(ClubService clubService){this.clubService = clubService;}

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubDtos = clubService.findAllCubs();
        model.addAttribute("clubs",clubDtos);
        return "club-list";
    }

    @GetMapping("club/{id}")
    public ResponseEntity<ClubDto> getClubById(@PathVariable long id) {
        ClubDto clubDto = clubService.findClubByID(id);
        return ResponseEntity.ok(clubDto);
    }

    @PostMapping("club/create")
    public ResponseEntity<ClubDto> saveClub(@RequestBody ClubDto clubDto) {
        ClubDto createdClub = clubService.createClub(clubDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClub);
    }

    @PutMapping("club/{id}/update")
    public ResponseEntity<Void> updateClub(@PathVariable long id, @RequestBody ClubDto clubDto) {
        clubDto.setId(id);
        clubService.updateClub(clubDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable long id) {
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }
}
