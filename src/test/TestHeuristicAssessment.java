package test;

import dao.InputInstance;
import entity.Table;
import resolver.State;
import resolver.heuristics.HeuristicAssessmentDistance;
import resolver.heuristics.HeuristicAssessmentHits;
import resolver.heuristics.HeuristicAssessmentLevel;

public class TestHeuristicAssessment {
    public static void main(String[] args) {
        Table t = InputInstance.getInstance("files/inst04.in");
        State s0 = new State(t);

        HeuristicAssessmentDistance distance = new HeuristicAssessmentDistance();
        HeuristicAssessmentHits hits = new HeuristicAssessmentHits();
        HeuristicAssessmentLevel level = new HeuristicAssessmentLevel();
        
        for (State s : s0.generateChildren()) {
            System.out.println(s);
            int points = distance.assess(s) + hits.assess(s) + level.assess(s);
            System.out.println("Heuristic : " + points);
        }
    }
}
