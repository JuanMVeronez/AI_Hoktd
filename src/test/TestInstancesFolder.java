package test;

import java.util.List;

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

public class TestInstancesFolder {
    public static void main(String[] args) {
        String folder = "files/inst";

        List<String> files = InputInstance.getFolderFiles(folder);

        for (String file : files) {
            System.out.println("Solving " + file);
            solveInstance(file);
        }
    }

    private static void solveInstance(String file) {
        Table t = InputInstance.getInstance(file);
        State s0 = new State(t);

        HeuristicAssessment heuristic = new HeuristicAssessmentAgregator(
            new HeuristicAssessmentDistance(),
            new HeuristicAssessmentHits(),
            new HeuristicAssessmentLevel()
        );

        StatesSpace space = new StatesSpace(s0, new PriorityStateQueue(heuristic));
        
        InputInstance.writeSolution(space.solve().getActions(), file);
    }
}
