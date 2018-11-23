package move;

import board.Coordinate;
import provider.IBoardSurfaceProvider;

public interface IMovePlugin {
	public void register(IBoardSurfaceProvider provider);
	public boolean checkMove(Coordinate source, Coordinate destination);
}
