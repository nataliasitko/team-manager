package com.teamManager.service;

import com.teamManager.exceptions.IdNotFoundException;
import com.teamManager.model.TeamMember;
import com.teamManager.repo.TeamMembersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TeamService {
    private final TeamMembersRepo teamMembersRepo;

    @Autowired
    public TeamService(TeamMembersRepo teamMembersRepo) {
        this.teamMembersRepo = teamMembersRepo;
    }

    public TeamMember addNewTeamMember(TeamMember teamMember){
        teamMember.setCode(UUID.randomUUID().toString());
        return teamMembersRepo.save(teamMember);
    }

    public TeamMember updateTeamMember(TeamMember teamMember){
        return teamMembersRepo.save(teamMember);
    }

    public void deleteTeamMember(Long id){
        teamMembersRepo.deleteById(id);
    }

    public TeamMember findTeamMemberById(Long id){
        return teamMembersRepo
                .findTeamMemberById(id)
                .orElseThrow(()
                        -> new IdNotFoundException("Team member of id " + id + " could not be found."));
    }

    public List<TeamMember> findAllTeamMembers(){
        return teamMembersRepo.findAll();
    }

}
