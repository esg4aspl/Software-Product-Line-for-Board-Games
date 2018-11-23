package move;

import board.Coordinate;
import board.IBoardSurface;
import provider.IBoardSurfaceProvider;

public class SingleMove implements IMovePlugin{
	private IBoardSurfaceProvider provider;
	@Override
	public void register(IBoardSurfaceProvider provider) {
		this.provider = provider;		
	}
	@Override
	public boolean checkMove(Coordinate source, Coordinate destination) {
//		Coordinate difference = source.subtractFrom(destination);  //single move olup olmadigini kontrol et
//		if(difference.getRow()==0 && difference.getColumn()==1) {
			
//		}
		
		IBoardSurface destinationSurface = provider.getBoardSurface(destination);
		System.out.println("movE:"+destinationSurface);
		
		if(!(destinationSurface==null)&&!(destinationSurface.getPieceFromSurface()==null)) {  // tas varsa		
			return false;
		}
		
		return true;
	}

}
