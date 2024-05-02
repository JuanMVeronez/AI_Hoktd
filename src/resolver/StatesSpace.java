package resolver;

import entity.generic.OpenState;
import resolver.heuristics.HeuristicAssessmentDistance;

public class StatesSpace {
    public State initial;
    public OpenState openState;

    public StatesSpace(State initialS, OpenState openState) {
        this.initial = initialS;
        this.openState = openState;
        openState.push(this.initial);
    }

    public State solve() {
        int iterations = 0;

        while(openState.size() > 0) {
            State e = openState.pop();
            System.out.println("TESTING STATE");
            System.out.println("POINTS TO STATE: " + new HeuristicAssessmentDistance().assess(e));
            System.out.println("ITERATIONS: " + iterations++);
            System.out.println(e);
            if(e.isObjective()) {
                System.out.println("-------------FOUND SOLUTION----------");
                System.out.println(e);
                return e;
            }
            for(State child : e.generateChildren()) {
                openState.push(child);
            }
        }

        System.out.println("no solution found");

        return null;
    }
}
