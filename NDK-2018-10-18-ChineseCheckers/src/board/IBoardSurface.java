package board;

import piece.IPiece;

public interface IBoardSurface {
	public IPiece getPieceFromSurface();
	public void addPiece(IPiece piece);
	public void removePiece();
	
}
