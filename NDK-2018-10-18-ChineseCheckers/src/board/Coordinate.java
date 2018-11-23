package board;

public class Coordinate {
	private int column;
	private int row;
	
	public Coordinate(int column, int row) {
		this.column = column;
		this.row = row;	
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column; 
	}
	
	public Coordinate sumTo(Coordinate cord) {
		return new Coordinate( (this.column + cord.getColumn()) , (this.row + cord.getRow()) );
	}
	
	public Coordinate subtractFrom(Coordinate cord) {
		return new Coordinate( (cord.getColumn() - this.column) , (cord.getRow() - this.row) );
	}
	
	public String toString() {
		return "( Row : " + row + " | " + "Column : " + column+" )";
	}

	public boolean equals(Object arg0) {
		Coordinate cord = (Coordinate) arg0;
		if(cord.getColumn() == this.column && cord.getRow() == this.row)
			return true;
		return false;
	}
}
