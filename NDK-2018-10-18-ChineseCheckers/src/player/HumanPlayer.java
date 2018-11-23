package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.Board;
import board.Coordinate;
import board.IBoardSurface;
import piece.IPiece;
import view.View;
import game.Refree;

public class HumanPlayer implements IPlayer {
	private String playerName;
	private List<IPiece> pieces;
	private Board board;
	private Refree referee;
	
	public HumanPlayer(Board board,String name, List<IPiece> pieces,Refree referee) {
		this.referee=referee;
		this.pieces=pieces;
		this.setPlayerName(name);
		this.board=board;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	@Override
	public void addPiece(IPiece piece) {
		pieces.add(piece);
	}
	
	@Override
	public void removePieceFromSurface(Coordinate pieceCoordinate) {
		IBoardSurface surface= board.getBoardSurface(pieceCoordinate);
		surface.removePiece();
	}
	
	@Override
	public void takeTurn(View view) {
		
		Coordinate source= view.getCoordinateFromUser("source");
		IBoardSurface surface= board.getBoardSurface(source);
		IPiece pieceToMove=surface.getPieceFromSurface();
		
		if(isMine(pieceToMove)) {
			
			Coordinate destination=view.getCoordinateFromUser("destination");
			if(referee.isCorrectMove(source, destination)) {
			removePieceFromSurface(source);
			movePiece(pieceToMove, destination);
			}
			else {
				System.out.println("Wrong direction");
				takeTurn(view);
			}
		}
		else {
			takeTurn(view);
		}

	}
	
	
	public boolean movePiece(IPiece piece, Coordinate destination) {

		IBoardSurface surface= board.getBoardSurface(destination);
		surface.addPiece(piece);
		return false;
	}
	
	@Override
	public boolean isMine(IPiece piece) {
		for(IPiece p:pieces) {
			if(p.equals(piece)) {
				return true;
			}
		}
		return false;
	}


}