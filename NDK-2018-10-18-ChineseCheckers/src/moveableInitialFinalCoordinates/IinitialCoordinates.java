package moveableInitialFinalCoordinates;
import java.util.List;

import board.Coordinate;

public interface IinitialCoordinates {
	public List<Coordinate> getGameableCoordinates();
	public List<List<Coordinate>> getPlayerPieceInitialPositionsPair();
	public List<List<Coordinate>> getPlayerPieceFinalPositionsPair();
}
