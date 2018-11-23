package moveableInitialFinalCoordinates;

import java.util.ArrayList;
import java.util.List;

import board.Coordinate;

public class CheckerCoordinates implements IinitialCoordinates {
	
	@Override
	public List<Coordinate> getGameableCoordinates() {
		// TODO Auto-generated method stub
		List<Coordinate> moveableCoordinates = new ArrayList<Coordinate>();
		for(int i=0; i<8;i++) {
			for(int j=0; j<8;j++) {
				moveableCoordinates.add(new Coordinate(j, i));
			}
		}
		return moveableCoordinates;
	}

	@Override
	public List<List<Coordinate>> getPlayerPieceInitialPositionsPair() {
		// TODO Auto-generated method stub
		List<List<Coordinate>> playerCoordinates = new ArrayList<List<Coordinate>>();
		List<Coordinate> player1 = new ArrayList<Coordinate>();
		List<Coordinate> player2 = new ArrayList<Coordinate>();
		for(int i = 1; i<3; i++)
			for(int j=0; j<8; j++)
				player1.add(new Coordinate(j,i));
		
		for(int i = 5; i<7; i++)
			for(int j=0; j<8; j++)
				player2.add(new Coordinate(j,i));
		
		playerCoordinates.add(player1);
		playerCoordinates.add(player2);
		
		return playerCoordinates;
	}

	@Override
	public List<List<Coordinate>> getPlayerPieceFinalPositionsPair() {
		// TODO Auto-generated method stub
		return null;
	}

}
