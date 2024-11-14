package com.sportradar.SportCalendar.repository;

import com.sportradar.SportCalendar.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Integer> {
    Optional<MatchEntity> findById(int id);

}
