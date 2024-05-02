package resolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import entity.Action;
import entity.Table;

public class State {
    private Table table;
    private List<Action> actions = new LinkedList<>();

    public State(Table table) {
        this.table = table;
    }

    public State(Table table, List<Action> actions) {
        this.table = table;
        this.actions = actions;
    }

    public boolean isObjective() {
        return this.table.isObjective();
    }

    public Collection<State> generateChildren() {
        Collection<State> children = new ArrayList<>();
		for(Action action: Action.values()) {
            if (!this.table.isValidAction(action)) continue;

            State child = this.deepCopy();
            child.act(action);
            children.add(child);
        }
        
        return children;
    }

    public void act(Action action) {
		this.actions.add(action);
		this.table.act(action);
	}

    public State deepCopy() {
		List<Action> newActions = new LinkedList<>(this.actions);
		return new State(this.table.deepCopy(), newActions);
	}

    @Override
    public String toString() {
        return this.table.toString();
    }
}