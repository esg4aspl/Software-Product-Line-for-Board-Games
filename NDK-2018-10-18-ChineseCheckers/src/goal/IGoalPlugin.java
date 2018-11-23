package goal;

import player.IPlayer;
import provider.IGoalProvider;

public interface IGoalPlugin {
	public IPlayer isOver(IGoalProvider goalProvider);
}
