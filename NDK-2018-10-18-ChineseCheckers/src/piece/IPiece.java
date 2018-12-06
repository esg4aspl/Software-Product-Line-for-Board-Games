package piece;

import board.Coordinate;
import enums.Color;
import player.IPlayer;

public interface IPiece {
	public Coordinate[] getMoveDirection();
	public Color getColor();
	public String getSymbol();
	public void setColor(Color color);
	public void addMoveDirection(Coordinate coordinate);
	public void removeMoveDirection(Coordinate coordinta);
	public void addPlayer(IPlayer player);
}
