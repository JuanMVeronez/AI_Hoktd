package entity;

public class Position {
	int line;
	int row;
	
	public Position(int line, int row) {
		super();
		this.line = line;
		this.row = row;
	}
	@Override
	public String toString() {
		return "(" + line + ", " + row + ")";
	}
	
	
	

}
