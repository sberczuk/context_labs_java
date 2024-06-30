package org.example;

import java.util.List;

public class ProductRule {
    public static class MatchStatus {
        public int numMatches;
        public int numConditions;
        public int possibleScore;

        public float resultScore() {
            return ((float) numMatches / numConditions) * possibleScore;
        }

        public MatchStatus(int numMatches, int numConditions, int possibleScore) {
            this.numMatches = numMatches;
            this.numConditions = numConditions;
            this.possibleScore = possibleScore;
        }

        @Override
        public String toString() {
            return String.format("matched %d of %d with total score of %f", numMatches, numConditions, resultScore());
        }
    }

    List<Condition> conditions;
    private final int score;

    public ProductRule(List<Condition> conditions, int score) {
        this.conditions = conditions;
        this.score = score;
    }

    public MatchStatus apply(Product p) {
        int matches = 0;

        // We could also use stream here
        for (Condition c : conditions) {
            if (c.apply(p)){
                matches = matches + 1;
            }
        }
        return new MatchStatus(matches,this.conditions.size(), this.score);
    }
}
