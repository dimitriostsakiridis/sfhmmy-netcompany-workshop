package com.auth.match_management.repositories;

import com.auth.match_management.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    //Check for match instances between two teams on a specific date
    boolean existsByTeamHomeNameAndTeamAwayNameAndDate(String teamHomeName, String teamAwayName, Date date);

    //Return all matches in descending order
    List<MatchEntity> findByOrderByIdDesc();
}
