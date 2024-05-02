package resolver.heuristics;

import resolver.State;

public class HeuristicAssessmentLevel implements HeuristicAssessment{
    @Override
    public int assess(State state) {
        return state.getLevel();
    }
}
