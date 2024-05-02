package resolver.heuristics;

import resolver.State;

public class HeuristicAssessmentDistance implements HeuristicAssessment {

    @Override
    public int assess(State state) {
        return state.getDistance();
    }
}
