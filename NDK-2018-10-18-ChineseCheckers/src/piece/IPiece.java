package piece;

import board.Coordinate;
import enums.Color;

public interface IPiece {
	public Coordinate[] getMoveDirection();
	public Color getColor();
	public String getSymbol();
	public void setColor(Color color);
	public void addMoveDirection(Coordinate coordinate);
	public void removeMoveDirection(Coordinate coordinta);
}
