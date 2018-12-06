package piece;
import java.util.ArrayList;
import java.util.List;

import board.Coordinate;
import enums.Color;

public class Piece implements IPiece {
	private List<Coordinate> listOfDirections;
	private Color color;
	private String symbol;
	private Coordinate initialLocation;
	
	public Piece(Color color,String sybmbol) {
		this.color = color;
		this.symbol = sybmbol;
		listOfDirections = new ArrayList<Coordinate>();
		initialLocation = new Coordinate(-1,-1);
	}
	
	public Piece(Color color,String sybmbol,Coordinate initialLocation) {
		this.initialLocation = initialLocation;
	}
	
	public Coordinate getInitialLocation() {
		return initialLocation;
	}
	
	@Override
	public Coordinate[] getMoveDirection() {
		Coordinate[] c = new Coordinate[listOfDirections.size()];
		return listOfDirections.toArray(c);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
	}

	@Override
	public void addMoveDirection(Coordinate coordinate) {
		// TODO Auto-generated method stub
		listOfDirections.add(coordinate);
	}

	@Override
	public void removeMoveDirection(Coordinate coordinte) {
		// TODO Auto-generated method stub
		listOfDirections.remove(coordinte);
	}
	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return symbol;
	}

}
