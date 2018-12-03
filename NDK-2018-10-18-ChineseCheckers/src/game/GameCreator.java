package game;

import java.util.ArrayList;
import java.util.List;
import move.IMovePlugin;
import move.JumpOverPiece;
import move.SingleMove;
import board.Board;
import board.BoardSurface;
import board.Coordinate;
import enums.Color;
import moveableInitialFinalCoordinates.IinitialCoordinates;
import piece.IPiece;
import piece.Piece;
import player.HumanPlayer;
import player.IPlayer;

public class GameCreator {
	private static String[] symbols = {"#","+","%","?","*","-"};
	private Board board;
	private List<IPlayer> players;
	private IinitialCoordinates initialCoordinates;
	private Refree referee;
	
	public GameCreator(IinitialCoordinates initialCoordinates) {
		this.initialCoordinates = initialCoordinates;
		players = new ArrayList<IPlayer>();
		
	}
	
	public Board getBoard() {
		return board;
	}
	
	public List<IPlayer> getPlayers(){
		return players;
	}
	
	public List<List<Coordinate>> getFinalCoordinates(){
		return initialCoordinates.getPlayerPieceFinalPositionsPair();
	} 
	
	private void createBoard(int column,int row) {
		//Comment from Deniz.
		board = new Board(column, row);
		IMovePlugin plugin= new SingleMove();
		IMovePlugin plugin2= new JumpOverPiece();
		referee=new Refree(board);
		referee.addMovePlugin(plugin);
		referee.addMovePlugin(plugin2);
		plugin.register(board);
		plugin2.register(board);
		
		List<Coordinate> moveableCoordinates = initialCoordinates.getGameableCoordinates();
		for(Coordinate c : moveableCoordinates)
			board.addSurface(c, new BoardSurface());
	}
	
	
	public void init(int column,int row,int numberOfPlayer,int numberOfPieceForEachPlayer) {
		createBoard(column, row);
		players = createPlayers(numberOfPlayer,numberOfPieceForEachPlayer);
	}
	
	
	private List<IPlayer> createPlayers(int numberOfPlayer,int numberOfPieceForEachPlayer) {

		List<IPlayer> players = new ArrayList<IPlayer>();
		List<List<Coordinate>> pieceInitialCoordinatesForEachPlayer = initialCoordinates.getPlayerPieceInitialPositionsPair();
		for(int i=0; i<numberOfPlayer; i++) {
			List<IPiece> pieces = new ArrayList<IPiece>();
			//each player has 10 piece for chinese checker
			for(int j=0; j<numberOfPieceForEachPlayer;j++) {
				IPiece p = new Piece(Color.values()[i],symbols[i]);
				helper(p);
				pieces.add(p);
				Coordinate c = pieceInitialCoordinatesForEachPlayer.get(i).get(j);
				board.getBoardSurface(c).addPiece(p);
			}
			players.add(new HumanPlayer(board,"Player "+(i+1), pieces,referee));
		}
		
		return players;
	}
	
	//move directions of piece 
	//in chinese checker one piece can be move to 6 direction with jump or single
	private void helper(IPiece p) {
		p.addMoveDirection(new Coordinate(-2, 0)); //left
		p.addMoveDirection(new Coordinate(-6, 0)); //left jump
		p.addMoveDirection(new Coordinate(2, 0));  //right
		p.addMoveDirection(new Coordinate(4, 0)); //right jump
		p.addMoveDirection(new Coordinate(-1, -1));//left upper
		p.addMoveDirection(new Coordinate(-2, -2));//left upper jump
		p.addMoveDirection(new Coordinate(1, -1));//right upper
		p.addMoveDirection(new Coordinate(-2, 2));//left down jump
		p.addMoveDirection(new Coordinate(2, -2));//right upper jump
		p.addMoveDirection(new Coordinate(-1, 1));//left down
		p.addMoveDirection(new Coordinate(1, 1));//right down
		p.addMoveDirection(new Coordinate(2, 2));//right down jump
	}
}
