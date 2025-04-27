package com.auth.match_management.services;

import com.auth.match_management.entities.MatchEntity;
import com.auth.match_management.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public MatchEntity createMatch(MatchEntity matchEntity) {
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
        return matchRepository.findAll();
    }

    public MatchEntity getMatchById(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found with id " + id));
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
