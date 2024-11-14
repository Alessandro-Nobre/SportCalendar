package com.sportradar.SportCalendar.repository;

import com.sportradar.SportCalendar.entities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
    TeamEntity getByTeamId(int teamId);
}
