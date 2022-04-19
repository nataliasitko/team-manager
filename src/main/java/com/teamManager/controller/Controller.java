package com.teamManager.controller;

import com.teamManager.model.TeamMember;
import com.teamManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamMember")
public class Controller {
    private final TeamService teamService;

    @Autowired
    public Controller(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/add")
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMember teamMember){
        TeamMember newTeamMember = teamService.addNewTeamMember(teamMember);
        return new ResponseEntity<>(newTeamMember, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TeamMember> updateTeamMember(@RequestBody TeamMember teamMember){
        TeamMember updatedTeamMember = teamService.updateTeamMember(teamMember);
        return new ResponseEntity<>(updatedTeamMember, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable("id") Long id){
        teamService.deleteTeamMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable("id") Long id){
        TeamMember teamMember = teamService.findTeamMemberById(id);
        return new ResponseEntity<>(teamMember, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TeamMember>> getAllTeamMembers(){
        List<TeamMember> teamMembers = teamService.findAllTeamMembers();
        return new ResponseEntity<>(teamMembers, HttpStatus.OK);
    }

}
