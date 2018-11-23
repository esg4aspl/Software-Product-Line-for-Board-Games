package goal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import board.Coordinate;
import board.IBoardSurface;
import player.IPlayer;
import provider.IGoalProvider;

public class PiecesToTarget implements IGoalPlugin {

	@Override
	public IPlayer isOver(IGoalProvider goalProvider) {
		// TODO Auto-generated method stub
		Map<IPlayer,List<Coordinate>> finish = goalProvider.getPlayerFinishPair();
		Set<IPlayer> players = finish.keySet();
		IBoardSurface[][] board = goalProvider.getBoard();
		
		for(IPlayer p : players) {
			int i=0;
			for(Coordinate c: finish.get(p)) {
				if(p.isMine(board[c.getRow()][c.getColumn()].getPieceFromSurface()))
					i++;
			}
			if(i==finish.get(p).size())
				return p;
		}
		return null;
	}
}
