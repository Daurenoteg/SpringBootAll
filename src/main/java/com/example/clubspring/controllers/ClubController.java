package com.example.clubspring.controllers;

import com.example.clubspring.models.clubDto.ClubDto;
import com.example.clubspring.services.impl.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
