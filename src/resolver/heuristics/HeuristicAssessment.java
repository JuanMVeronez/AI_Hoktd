package resolver.heuristics;

import resolver.State;

public interface HeuristicAssessment {
    public int assess(State state);
}
