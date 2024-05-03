package test;

import dao.InputInstance;
import entity.Table;
import entity.generic.PriorityStateQueue;
import resolver.State;
import resolver.StatesSpace;
import resolver.heuristics.HeuristicAssessment;
import resolver.heuristics.HeuristicAssessmentAgregator;
import resolver.heuristics.HeuristicAssessmentDistance;
import resolver.heuristics.HeuristicAssessmentHits;
import resolver.heuristics.HeuristicAssessmentLevel;

public class TestPriorityStateSolver {
    public static void main(String[] args) {
        Table t = InputInstance.getInstance("files/inst05.in");
        State s0 = new State(t);

        HeuristicAssessment heuristic = new HeuristicAssessmentAgregator(
            new HeuristicAssessmentDistance(),
            new HeuristicAssessmentHits(),
            new HeuristicAssessmentLevel()
        );

        StatesSpace space = new StatesSpace(s0, new PriorityStateQueue(heuristic));
        
        System.out.println("Solution: " + space.solve());
    }
}
