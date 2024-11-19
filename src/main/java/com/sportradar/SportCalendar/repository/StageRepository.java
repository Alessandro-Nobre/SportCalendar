package com.sportradar.SportCalendar.repository;

import com.sportradar.SportCalendar.entities.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<StageEntity, Integer> {
}
