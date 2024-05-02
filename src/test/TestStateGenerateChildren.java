package test;

import dao.InputInstance;
import entity.Table;
import resolver.State;

public class TestStateGenerateChildren {
    public static void main(String[] args) {
        Table t = InputInstance.getInstance("files/inst04.in");
        State s0 = new State(t);

        System.out.println("Base State:");
        System.out.println(s0);

        System.out.println("Children:");
        for(State s : s0.generateChildren()) {
            System.out.println(s);
        }
    }
}
