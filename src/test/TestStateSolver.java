package test;

import dao.InputInstance;
import entity.Table;
import entity.generic.StatesQueue;
import resolver.State;
import resolver.StatesSpace;

public class TestStateSolver {
    public static void main(String[] args) {
        Table t = InputInstance.getInstance("files/inst04.in");
		State e = new State(t);
		System.out.println("Starts with:");
		System.out.println(e);
		
		StatesSpace space = new StatesSpace(e, new StatesQueue());
		System.out.println(e);
        System.out.println("Solution:");
        System.out.println(space.solve());
    }
}
