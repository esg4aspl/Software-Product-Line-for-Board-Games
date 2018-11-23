package provider;

import board.Coordinate;
import board.IBoardSurface;

public interface IBoardSurfaceProvider {
	public IBoardSurface getBoardSurface(Coordinate coordinate);
}
