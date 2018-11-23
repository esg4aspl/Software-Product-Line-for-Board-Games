package provider;

import java.util.List;
import java.util.Map;

import board.Coordinate;
import board.IBoardSurface;
import player.IPlayer;

public interface IGoalProvider {
	public Map<IPlayer,List<Coordinate>> getPlayerFinishPair();
	public IBoardSurface[][] getBoard(); 
}
