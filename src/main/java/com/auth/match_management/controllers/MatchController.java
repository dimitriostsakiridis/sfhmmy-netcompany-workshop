package com.auth.match_management.controllers;

import com.auth.match_management.entities.MatchEntity;
import com.auth.match_management.services.MatchService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createMatch(@RequestBody MatchEntity matchEntity) {
        try{
            matchService.createMatch(matchEntity);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(matchEntity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public MatchEntity updateMatch(@PathVariable Long id, @RequestBody MatchEntity matchEntity) {
        return matchService.updateMatch(id, matchEntity);
    }

    @GetMapping
    @Transactional
    public List<MatchEntity> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    @Transactional
    public MatchEntity getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok().build();
    }
}
