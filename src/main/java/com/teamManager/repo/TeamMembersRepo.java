package com.teamManager.repo;

import com.teamManager.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamMembersRepo extends JpaRepository<TeamMember, Long> {

    void deleteById(Long id);

    Optional<TeamMember> findTeamMemberById(Long id);

}
