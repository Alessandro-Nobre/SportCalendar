package com.sportradar.SportCalendar.repository;

import com.sportradar.SportCalendar.entities.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Integer> {
}
