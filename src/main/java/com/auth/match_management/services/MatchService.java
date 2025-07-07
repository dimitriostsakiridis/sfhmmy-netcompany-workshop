package com.auth.match_management.services;

import com.auth.match_management.entities.MatchEntity;
import com.auth.match_management.repositories.MatchRepository;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public MatchEntity createMatch(MatchEntity matchEntity) throws Exception {
        //Null object check
        if(matchEntity.isNull()){
            throw new Exception("Match is null");
        }

        Integer goals_h = matchEntity.getTeamHomeGoals();
        Integer goals_a = matchEntity.getTeamAwayGoals();

        if (goals_h == null || goals_a == null) {
            throw new IllegalArgumentException("Goals cannot be null");
        }else if(goals_h<0 || goals_a<0){
            throw new IllegalArgumentException("Goals cannot be negative");
        }


        Date date = Date.valueOf(LocalDate.now());
        String home = matchEntity.getTeamHomeName();
        String away = matchEntity.getTeamAwayName();

        //Bidirectional search for matches at the current date
        boolean exists_h = matchRepository.existsByTeamHomeNameAndTeamAwayNameAndDate(home, away, date);
        boolean exists_a = matchRepository.existsByTeamHomeNameAndTeamAwayNameAndDate(away, home, date);

        if(exists_h || exists_a) {
            throw new IllegalArgumentException("Match already exists");
        }
        return matchRepository.save(matchEntity);

    }

    public MatchEntity updateMatch(Long id, MatchEntity updatedMatch) {
        return matchRepository.findById(id)
                .map(matchEntity1 -> {
                    matchEntity1.setTeamHomeGoals(updatedMatch.getTeamHomeGoals());
                    matchEntity1.setTeamAwayGoals(updatedMatch.getTeamAwayGoals());
                    return matchRepository.save(matchEntity1);
                }).orElseThrow(() -> new RuntimeException("Match not found with id " + id));
    }

    public List<MatchEntity> getAllMatches() {
        return matchRepository.findByOrderByIdDesc();
    }

    public MatchEntity getMatchById(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found with id " + id));
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
