package entity.generic;

import java.util.Comparator;
import java.util.PriorityQueue;

import resolver.State;
import resolver.heuristics.HeuristicAssessment;

public class PriorityStateQueue implements OpenState {
    public HeuristicAssessment heuristicAssessment;
    public PriorityQueue<State> queue = new PriorityQueue<>(new StateComparator());

    public PriorityStateQueue(HeuristicAssessment heuristicAssessment) {
        this.heuristicAssessment = heuristicAssessment;
    }

    @Override
    public void push(State state) {
        queue.add(state);
    }

    @Override
    public State pop() {
        return queue.poll();
    }

    @Override
    public int size() {
        return queue.size();
    }

    class StateComparator implements Comparator<State> {
        @Override
        public int compare(State s1, State s2) {
            double assessment1 = heuristicAssessment.assess(s1);
            double assessment2 = heuristicAssessment.assess(s2);
            return Double.compare(assessment1, assessment2);
        }
    }
}
