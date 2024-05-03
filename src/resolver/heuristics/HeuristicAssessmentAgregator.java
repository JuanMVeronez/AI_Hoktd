package resolver.heuristics;

import resolver.State;

public class HeuristicAssessmentAgregator implements HeuristicAssessment {
    public HeuristicAssessment[] heuristics;

    public HeuristicAssessmentAgregator(HeuristicAssessment... heuristics) {
        this.heuristics = heuristics;
    }

    @Override
    public int assess(State state) {
        int assessment = 0;
        for (HeuristicAssessment heuristic : heuristics) {
            assessment += heuristic.assess(state);
        }
        return assessment;
    }
}
