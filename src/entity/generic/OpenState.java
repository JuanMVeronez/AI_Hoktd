package entity.generic;

import resolver.State;

public interface OpenState {
    public void push(State state);
    public State pop();
    public int size();   
}
