package board;

import provider.IBoardSurfaceProvider; // for the plugin does not know about whole board

public class Board implements IBoardSurfaceProvider{
	private IBoardSurface[][] boardIndexes;
	
	public Board(int column, int row) {
		boardIndexes = new IBoardSurface[row][column];
	}
	
	/**
	 * get square from given coordinate.
	 * if square is not in the board, return null
	 * @return square or null
	 */
	public IBoardSurface getBoardSurface(Coordinate coordinate) {
		if(isCoordinateOnBoard(coordinate))
			return boardIndexes[coordinate.getRow()][coordinate.getColumn()];
		else
			return null;
	}
	
	
	public void addSurface(Coordinate coordinate, IBoardSurface surface) {
		if(isCoordinateOnBoard(coordinate))
			boardIndexes[coordinate.getRow()][coordinate.getColumn()] = surface;
		else
			System.out.println("Error!!!!! this coordinate is not on BOARD!!!"); // it must be changed!!!!!
	}
	
	
	public boolean removeSurface(Coordinate coordinate) {
		if(isCoordinateOnBoard(coordinate)) {
			boardIndexes[coordinate.getRow()][coordinate.getColumn()] = null;
			return true;
		}else
			return false;
	}
	
	
	/**
	 * coordinate is on the board or not
	 * @param coordinate
	 * @return boolean
	 */
	public boolean isCoordinateOnBoard(Coordinate coordinate) {
		int row = coordinate.getRow();
		int column = coordinate.getColumn();
		if(row<=boardIndexes.length && column<=boardIndexes[0].length)
			return true;
		return false;
	}
	
	public int getRowSize() {
		return boardIndexes.length;
	}
	
	public int getColumnSize() {
		return boardIndexes[0].length;
	}
	
	public IBoardSurface[][] getWholeBoard(){
		return boardIndexes.clone();
	}
}

