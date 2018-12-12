package com.tw.bc;

import java.util.HashMap;
import java.util.Map;

public class RuleEngine {
    private static final Map<State, IUpdateScore> ruleMap = new HashMap<>();

    public RuleEngine() {
        initializeRuleEngine();
    }

    private void initializeRuleEngine() {
        ruleMap.put(new State(TrustChoice.COOPERATE, TrustChoice.COOPERATE), (pl1, pl2) -> {
            pl1.addScore(Score.COOP_SCORE);
            pl2.addScore(Score.COOP_SCORE);
        });

        ruleMap.put(new State(TrustChoice.COOPERATE, TrustChoice.CHEAT), (pl1, pl2) -> {
            pl1.addScore(Score.LOSER_SCORE);
            pl2.addScore(Score.CHEAT_SCORE);
        });

        ruleMap.put(new State(TrustChoice.CHEAT, TrustChoice.COOPERATE), (pl1, pl2) -> {
            pl1.addScore(Score.CHEAT_SCORE);
            pl2.addScore(Score.LOSER_SCORE);
        });

        ruleMap.put(new State(TrustChoice.CHEAT, TrustChoice.CHEAT), (pl1, pl2) -> {
            pl1.addScore(Score.NEUTRAL_SCORE);
            pl2.addScore(Score.NEUTRAL_SCORE);
        });
    }

    public IUpdateScore getScoreUpdater(State state) {
        return ruleMap.get(state);
    }

}
