package resolver.heuristics;

import resolver.State;

public class HeuristicAssessmentHits implements HeuristicAssessment {
    @Override
    public int assess(State state) {
        return state.getHits();
    }
}
