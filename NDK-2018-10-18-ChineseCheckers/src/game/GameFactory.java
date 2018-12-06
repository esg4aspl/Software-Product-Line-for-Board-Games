package game;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.BoardSurface;
import board.Coordinate;
import dataAccessLayer.DAL;
import moveableInitialFinalCoordinates.ChineseCheckerCoordinates;
import moveableInitialFinalCoordinates.IinitialCoordinates;
import piece.IPiece;
import player.HumanPlayer;
import player.IPlayer;

public class GameFactory {
	private int numberOfPlayer;
	private DAL dal;
	private IinitialCoordinates initialCoordinates;
	public GameFactory(int numberOfPlayer) {
		this.numberOfPlayer=numberOfPlayer;
		dal=new DAL();
		initialCoordinates = new ChineseCheckerCoordinates(numberOfPlayer);
	}
	/**
	 * delegates Data Access Layer to read piece data from xml 
	 * and adds created pieces to related player and vice versa
	 * @param playerList
	 */
	public void makePieces(List<IPlayer> players){
		int count=1;
		List<IPiece> pieces = new ArrayList<IPiece>();
		for(IPlayer p: players) {
			pieces = dal.getPlayerPiecesFromXML("Player"+count, numberOfPlayer);
			for(IPiece piece:pieces) {
				piece.addPlayer(p);
			}
			p.setPieces(pieces);
			count++;
		}
	}
	/**
	 * Creates new players with respect to numberOfPlayer
	 * @return playerList
	 */
	public List<IPlayer> makePlayers(){
		List<IPlayer>playerList = new ArrayList<IPlayer>();
		for(int i=0; i < numberOfPlayer; i++) {
			IPlayer newPlayer = new HumanPlayer();
			playerList.add(newPlayer);
		}
		return playerList;
	}
	/**
	 * Creates board and adds squares to the board
	 * @param column: number of column of the board
	 * @param row: number of row of the board
	 * @return
	 */
	public Board makeBoard(int column, int row) {
		Board board = new Board(column, row);
		List<Coordinate> moveableCoordinates = initialCoordinates.getGameableCoordinates();
		for(Coordinate c : moveableCoordinates) {
			board.addSurface(c, new BoardSurface());
		}
		return board;
	}
	
}
