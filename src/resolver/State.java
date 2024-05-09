package resolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import entity.Action;
import entity.Table;

public class State {
    private Table table;
    private int hits;
    private List<Action> actions = new LinkedList<>();

    public State(Table table) {
        this.table = table;
        this.hits = 0;
    }

    public State(Table table, int hits, List<Action> actions) {
        this.table = table;
        this.hits = hits;
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
        this.hits += this.table.getPositionHits();
	}

    public State deepCopy() {
		List<Action> newActions = new LinkedList<>(this.actions);
        return new State(this.table.deepCopy(), this.hits, newActions);
	}

    public int getHits() {
        return this.hits;
    }

    public int getLevel() {
        return this.actions.size();
    }

    public int getDistance() {
        return this.table.getDistance();
    }

    public List<Action> getActions() {
        return this.actions;
    }

    @Override
    public String toString() {
        String res = "\n";
		res += "level: " + this.getLevel() + "\n";
        res += "hits: " + this.hits + "\n";
		res += this.table + "\n";
		for(Action action: this.actions) {
			res += action + ", ";
		}
		res += "\n";
		
		return res;
    }
}