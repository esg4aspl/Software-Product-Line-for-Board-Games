package move;

import board.Coordinate;
import board.IBoardSurface;
import provider.IBoardSurfaceProvider;

public class JumpOverPiece implements IMovePlugin{
	private IBoardSurfaceProvider provider;
	
	@Override
	public void register(IBoardSurfaceProvider provider) {
		this.provider = provider;		
	}
	
	@Override
	public boolean checkMove(Coordinate source, Coordinate destination) {
		Coordinate difference = source.subtractFrom(destination);
		Coordinate coordinateOfMiddlePiece = source.sumTo(difference);
		IBoardSurface middleSurface = provider.getBoardSurface(coordinateOfMiddlePiece);
			//ortada surface var mi				ortadaki surface de tas var mi
		if(!middleSurface.equals(null) && !middleSurface.getPieceFromSurface().equals(null)) {
			//IBoardSurface sourceSurface = provider.getBoardSurface(source);
			IBoardSurface destinationSurface = provider.getBoardSurface(destination);
				// hedefte surface var mi 			hedefte tas var mi
			if(!destinationSurface.equals(null) && !destinationSurface.getPieceFromSurface().equals(null)) {  // tas varsa		
				return false;
			}	
		}
		return true;
	}
	
}
