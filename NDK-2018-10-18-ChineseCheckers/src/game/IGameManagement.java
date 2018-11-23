package game;

import board.Coordinate;
import piece.IPiece;

public interface IGameManagement {
	public boolean isValidMove(IPiece piece, Coordinate source, Coordinate destination);
}
