package move;

import board.Coordinate;
import game.Refree;
import piece.IPiece;


public abstract class Move {
	IPiece piece;
	
	final public void move(Coordinate source, Coordinate destination, Refree referee) {
		selectPiece(source, referee); 
		inOperation(source, destination, referee); //optional				
		putPieceToBoard(destination, referee);
		postOperation(source, destination, referee); //optional
		
		
	}	
	
	public void selectPiece(Coordinate source, Refree referee) { // select piece
		this.piece = referee.getPieceFromCoordinate(source);
	}


	
	
	public abstract void inOperation(Coordinate source, Coordinate destination, Refree referee); 
	

	
	public void putPieceToBoard(Coordinate destination, Refree referee) {
		referee.putPieceToSquare(destination, piece);
	}
	
	public abstract void postOperation(Coordinate source, Coordinate destination, Refree referee);  // check more move, after the move 
		
}
