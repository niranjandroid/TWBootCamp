package com.tw.bc;

import java.util.HashMap;
import java.util.Map;

public class RuleEngine {
    private static final Map<State, Score[]> ruleMap = new HashMap<>();

    public RuleEngine() {
        initializeRuleEngine();
    }

    private void initializeRuleEngine() {
        ruleMap.put(new State(TrustChoice.COOPERATE, TrustChoice.COOPERATE),
                new Score[]{Score.COOP_SCORE, Score.COOP_SCORE});

        ruleMap.put(new State(TrustChoice.COOPERATE, TrustChoice.CHEAT),
                new Score[]{Score.LOSER_SCORE, Score.CHEAT_SCORE});

        ruleMap.put(new State(TrustChoice.CHEAT, TrustChoice.COOPERATE),
                new Score[]{Score.CHEAT_SCORE, Score.LOSER_SCORE});

        ruleMap.put(new State(TrustChoice.CHEAT, TrustChoice.CHEAT),
                new Score[]{Score.NEUTRAL_SCORE, Score.NEUTRAL_SCORE});
    }

    public Score[] getScoreUpdater(State state) {
        return ruleMap.get(state);
    }

}
