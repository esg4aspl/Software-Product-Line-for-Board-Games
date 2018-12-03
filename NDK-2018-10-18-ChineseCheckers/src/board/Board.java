package board;

import provider.IBoardSurfaceProvider;
// Comment from Kaan
public class Board implements IBoardSurfaceProvider{
	private IBoardSurface[][] boardIndexes;
	
	public Board(int column,int row) {
	
		boardIndexes = new IBoardSurface[row][column];
	}
	// coordinat da x column 
	
	//koordinatlar dýþarýda kontrol edilecektir
	public IBoardSurface getBoardSurface(Coordinate coordinate) {
		//IBoardSurface surface = null;
		//daha sonra coordinate kontrol edilecek
		return boardIndexes[coordinate.getRow()][coordinate.getColumn()];
		//return surface;
	}
	
	public void addSurface(Coordinate coordinate, IBoardSurface surface) {
		if(checkCoordinate(coordinate))
			boardIndexes[coordinate.getRow()][coordinate.getColumn()] = surface;
		else
			System.out.println("Error!!!!! this coordinate is not on BOARD!!!");
	}
	
	public void removeSurface(Coordinate coordinate) {
		//kontrol daha sonra yapýlacak
		if(checkCoordinate(coordinate))
			boardIndexes[coordinate.getRow()][coordinate.getColumn()] = null;
	}
	
	//daha sonra kontrol yapýlacak
	public boolean checkCoordinate(Coordinate coordinate) {
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
