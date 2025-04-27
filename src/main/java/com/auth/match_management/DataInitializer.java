package com.auth.match_management;

import com.auth.match_management.entities.MatchEntity;
import com.auth.match_management.services.MatchService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final MatchService matchService;

    public DataInitializer(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public void run(String... args) throws Exception {
        MatchEntity matchEntity1 = new MatchEntity();
        matchEntity1.setTeamHomeName("TestHome 1");
        matchEntity1.setTeamAwayName("TestAway 1");

        MatchEntity matchEntity2 = new MatchEntity();
        matchEntity2.setTeamHomeName("TestHome 2");
        matchEntity2.setTeamAwayName("TestAway 2");

        matchService.createMatch(matchEntity1);
        matchService.createMatch(matchEntity2);
    }
}
