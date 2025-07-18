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

        MatchEntity matchEntity3 = new MatchEntity();
        matchEntity3.setTeamHomeName("TestAway 3");
        matchEntity3.setTeamAwayName("TestHome 3");

        MatchEntity matchEntity4 = new MatchEntity();
        matchEntity4.setTeamHomeName("TestAway 2");
        matchEntity4.setTeamAwayName("TestHome 2");


        try{
            matchService.createMatch(matchEntity1);
            matchService.createMatch(matchEntity2);
            matchService.createMatch(matchEntity3);
            matchService.createMatch(matchEntity4);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
