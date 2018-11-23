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
		
		/* optional methodlar�n �a�r�l�p �a�r�lmayaca��n� burada m� kontrol etmeliyiz? 
		 * e�er burada kontrol edersek, optional methodlar ihtiya� halinde �al��acak
		 * burada kontrol etmezsek, baz� move tiplerindeki optional methodlar�n i�i bo� olsa da �al��acak
		 * i�i bo� oldu�u i�in bir i�lem yapmayacak
		 */
	}	
	
	public void selectPiece(Coordinate source, Refree referee) { // select piece
		this.piece = referee.getPiece(source);
	}


	
	/* inOperation optional oldu�u i�in baz� move tiplerinde bo� kalacak, bo� olmas� problem olu�turur mu?
	 * 
	 */
	public abstract void inOperation(Coordinate source, Coordinate destination, Refree referee); 
	

	
	public void putPieceToBoard(Coordinate destination, Refree referee) {
		referee.putPieceToSquare(destination, piece);
	}
	
	
	public abstract void postOperation(Coordinate source, Coordinate destination, Refree referee);  // check more move, after the move 
		
}
