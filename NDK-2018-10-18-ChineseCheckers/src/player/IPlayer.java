package player;

import java.util.List;

import board.Coordinate;
import piece.IPiece;
import view.View;

public interface IPlayer {
	//public void setBoard(Board board);
	public String getPlayerName();
	public void setPlayerName(String playerName);
	public void addPiece(IPiece pieces);
	//public void movePiece(Coordinate source, Coordinate destination);
	public boolean isMine(IPiece piece);
	public void removePieceFromSurface(Coordinate pieceCoordinate);
	public void takeTurn(View view);
	public void setPieces(List<IPiece> pieces);
	public List<IPiece> getPieces();
}
