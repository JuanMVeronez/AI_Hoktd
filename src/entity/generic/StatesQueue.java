package entity.generic;

import java.util.LinkedList;

import resolver.State;

public class StatesQueue implements OpenState {
	java.util.Queue<State> elements = new LinkedList<>();

	@Override
	public void push(State state) {
		elements.add(state);
	}

	@Override
	public State pop() {
		return elements.poll();
	}

	@Override
	public int size() {
		return elements.size();
	}

}
