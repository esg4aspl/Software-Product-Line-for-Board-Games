package moveableInitialFinalCoordinates;

import java.util.ArrayList;
import java.util.List;

import board.Coordinate;

public class ChineseCheckerCoordinates implements IinitialCoordinates {
	private int playerNumber;
	
	private List<Coordinate> middleUpperInitialCoordinate;
	private List<Coordinate> middleLowerInitialCoordinate;
	private List<Coordinate> rightUpperInitialCoordinate;
	private List<Coordinate> rightLowerInitialCoordinate;
	private List<Coordinate> leftUpperInitialCoordinate;
	private List<Coordinate> leftLowerInitialCoordinate;
	
	public ChineseCheckerCoordinates(int playerNumber) {
		// TODO Auto-generated constructor stub
		this.playerNumber = playerNumber;
		
		middleUpperInitialCoordinate = new ArrayList<Coordinate>();
		middleLowerInitialCoordinate = new ArrayList<Coordinate>();
		rightUpperInitialCoordinate = new ArrayList<Coordinate>();
		rightLowerInitialCoordinate = new ArrayList<Coordinate>();
		leftUpperInitialCoordinate = new ArrayList<Coordinate>();
		leftLowerInitialCoordinate = new ArrayList<Coordinate>();
		
		fill();
		
	}
	
	@Override
	public List<Coordinate> getGameableCoordinates() {
		// TODO Auto-generated method stub
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		
		helperForHoleMoveable(0, 12, 13,coordinates);
		helperForHoleMoveable(1, 11, 14,coordinates);
		helperForHoleMoveable(2, 10, 15,coordinates);
		helperForHoleMoveable(3, 9, 16,coordinates);
		//
		helperForHoleMoveable(4, 0, 25,coordinates);
		helperForHoleMoveable(5, 1, 24,coordinates);
		helperForHoleMoveable(6, 2, 23,coordinates);
		helperForHoleMoveable(7, 3, 22,coordinates);
		helperForHoleMoveable(8, 4, 21,coordinates);
		//
		helperForHoleMoveable(9, 3, 22,coordinates);
		helperForHoleMoveable(10, 2, 23,coordinates);
		helperForHoleMoveable(11, 1, 24,coordinates);
		helperForHoleMoveable(12, 0, 25,coordinates);
		//
		helperForHoleMoveable(13, 9, 16,coordinates);
		helperForHoleMoveable(14, 10, 15,coordinates);
		helperForHoleMoveable(15, 11, 14,coordinates);
		helperForHoleMoveable(16, 12, 13,coordinates);
		return coordinates;
	}

	@Override
	public List<List<Coordinate>> getPlayerPieceInitialPositionsPair() {
		// TODO Auto-generated method stub
		List<List<Coordinate>> playerInitial = new ArrayList<List<Coordinate>>();
		if(playerNumber==2) {
			playerInitial.add(middleUpperInitialCoordinate);
			playerInitial.add(middleLowerInitialCoordinate);
		}else if(playerNumber==3) {
			playerInitial.add(leftUpperInitialCoordinate);
			playerInitial.add(middleLowerInitialCoordinate);
			playerInitial.add(rightUpperInitialCoordinate);
		}else if(playerNumber==4) {
			playerInitial.add(leftUpperInitialCoordinate);
			playerInitial.add(leftLowerInitialCoordinate);
			playerInitial.add(rightLowerInitialCoordinate);
			playerInitial.add(rightUpperInitialCoordinate);
		}else if(playerNumber==6) {
			playerInitial.add(middleUpperInitialCoordinate);
			playerInitial.add(leftUpperInitialCoordinate);
			playerInitial.add(leftLowerInitialCoordinate);
			playerInitial.add(middleLowerInitialCoordinate);
			playerInitial.add(rightLowerInitialCoordinate);
			playerInitial.add(rightUpperInitialCoordinate);
		}
		return playerInitial;
	}
	/*
	 * (non-Javadoc)
	 * @see gameableInitialFinalCoordinates.IinitialCoordinates#getPlayerPieceFinalPositionsPair()
	 * return orderly finishing coordinate according to number of player
	 * suppose number of player is 2 and initial coordinates to start game are
	 * for player1 start middleUpper and finish coordinate middleLower 
	 * for player2 start middleLower and finish coordinate middleUpper
	 */
	@Override
	public List<List<Coordinate>> getPlayerPieceFinalPositionsPair() {
		List<List<Coordinate>> playerInitial = new ArrayList<List<Coordinate>>();
		if(playerNumber==2) {
			playerInitial.add(middleLowerInitialCoordinate);
			playerInitial.add(middleUpperInitialCoordinate);
		}else if(playerNumber==3) {
			playerInitial.add(rightLowerInitialCoordinate);
			playerInitial.add(middleUpperInitialCoordinate);
			playerInitial.add(leftLowerInitialCoordinate);
		}else if(playerNumber==4) {
			playerInitial.add(rightLowerInitialCoordinate);
			playerInitial.add(rightUpperInitialCoordinate);
			playerInitial.add(leftUpperInitialCoordinate);
			playerInitial.add(leftLowerInitialCoordinate);
		}else if(playerNumber==6) {
			playerInitial.add(middleLowerInitialCoordinate);
			playerInitial.add(rightLowerInitialCoordinate);
			playerInitial.add(rightUpperInitialCoordinate);
			playerInitial.add(middleUpperInitialCoordinate);
			playerInitial.add(leftUpperInitialCoordinate);
			playerInitial.add(leftLowerInitialCoordinate);
		}
		return playerInitial;
	}
	
	private void helperForHoleMoveable(int row,int low,int high,List<Coordinate> coordList) {
		for(int i=low; i<high; i++) {
			if((row%2 ==0 && i%2==0) || (row%2!=0 && i%2!=0) )
				coordList.add(new Coordinate(i, row));
		}
	}
	
	private void fill() {
		//middleUpper
		addCoordinate(0, 12, 13,middleUpperInitialCoordinate);
		addCoordinate(1, 11, 14,middleUpperInitialCoordinate);
		addCoordinate(2, 10, 15,middleUpperInitialCoordinate);
		addCoordinate(3, 9, 16,middleUpperInitialCoordinate);
		//
		addCoordinate(4,0, 7, leftUpperInitialCoordinate);
		addCoordinate(5, 1, 6,leftUpperInitialCoordinate);
		addCoordinate(6, 2, 5,leftUpperInitialCoordinate);
		addCoordinate(7, 3, 4,leftUpperInitialCoordinate);
		//
		addCoordinate(4,18, 25,rightUpperInitialCoordinate);
		addCoordinate(5,19, 24,rightUpperInitialCoordinate);
		addCoordinate(6,20, 23,rightUpperInitialCoordinate);
		addCoordinate(7,21, 22,rightUpperInitialCoordinate);
		//
		//left lower
		addCoordinate(9,3, 4, leftLowerInitialCoordinate);
		addCoordinate(10,2, 5,leftLowerInitialCoordinate);
		addCoordinate(11, 1, 6,leftLowerInitialCoordinate);
		addCoordinate(12, 0, 7,leftLowerInitialCoordinate);
		//
		//rightLower
		addCoordinate(9,21,22, rightLowerInitialCoordinate);
		addCoordinate(10,20,23,rightLowerInitialCoordinate);
		addCoordinate(11,19,24,rightLowerInitialCoordinate);
		addCoordinate(12,18,25,rightLowerInitialCoordinate);
		//
		//middleLower
		addCoordinate(16, 12, 13,middleLowerInitialCoordinate);
		addCoordinate(15, 11, 14,middleLowerInitialCoordinate);
		addCoordinate(14, 10, 15,middleLowerInitialCoordinate);
		addCoordinate(13, 9, 16,middleLowerInitialCoordinate);
		
	}
	
	private void addCoordinate(int row,int lowerIndex,int upperIndex,List<Coordinate> coordinates) {
		for(int i=lowerIndex; i<upperIndex; i++) {
			if((row%2 ==0 && i%2==0) || (row%2!=0 && i%2!=0) )
				coordinates.add(new Coordinate(i,row));
		}
	}

}
