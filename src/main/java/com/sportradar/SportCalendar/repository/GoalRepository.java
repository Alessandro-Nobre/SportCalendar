package com.sportradar.SportCalendar.repository;

import com.sportradar.SportCalendar.entities.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Integer> {
}
