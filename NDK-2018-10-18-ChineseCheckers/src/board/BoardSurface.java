package board;

import piece.IPiece;

public class BoardSurface implements IBoardSurface {
	private IPiece piece;
	
	public BoardSurface() {
		piece = null;
	}
	
	@Override
	public IPiece getPieceFromSurface() {
		// TODO Auto-generated method stub
		return piece;
	}
	@Override
	public void addPiece(IPiece piece) {
		// TODO Auto-generated method stub
		this.piece = piece;
	}
	@Override
	public void removePiece() {
		// TODO Auto-generated method stub
		piece=null;
	}
	
	
}
