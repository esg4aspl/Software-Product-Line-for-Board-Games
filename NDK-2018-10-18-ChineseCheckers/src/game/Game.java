package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.Board;

import board.Coordinate;
import board.IBoardSurface;

import goal.IGoalPlugin;
import goal.PiecesToTarget;
import moveableInitialFinalCoordinates.ChineseCheckerCoordinates;
import moveableInitialFinalCoordinates.IinitialCoordinates;
import player.IPlayer;
import provider.IGoalProvider;
import view.View;

public class Game implements IGoalProvider{
	private Board board;
	private List<IPlayer> players;
	private Map<IPlayer, List<Coordinate>> finalDestinationsForEachPlayer;
	private View view;
	//for now goal plug in number is one later can be change number of goal plug in 
	//and this can change to list 
	private IGoalPlugin goalPlugin;
	
	private Refree referee;

	public Game(View view,Board board,List<IPlayer> players,IGoalPlugin goalPlugin, Refree referee) {
		this.view = view;
		this.board =board;
		this.goalPlugin = goalPlugin;
		this.players =players;
		this.referee = referee;
		finalDestinationsForEachPlayer = new HashMap<IPlayer, List<Coordinate>>();
	}

	public void mapPlayerAndFinishCoordinates(List<List<Coordinate>> coor) {
		int i = 0;
		for(IPlayer p : players) {
			finalDestinationsForEachPlayer.put(p, coor.get(i));
			i++;
		}
	}

	public void start() {
		view.printBoard();

		List<String> playerNames = view.getPlayerNames(players.size());

		for(int i = 0; i<players.size(); i++) {
			players.get(i).setPlayerName(playerNames.get(i));
		}

	

		//	Coordinate c  = view.getCoordinateFromUser("Source");
		//	System.out.println(c.getColumn()+" "+c.getRow());
		//System.out.println(board.getBoardSurface(c).getPieceFromSurface().getSymbol());

		//Coordinate c1  = view.getCoordinateFromUser("Destination");
		//	System.out.println(c1.getColumn()+" "+c1.getRow());
		//	System.out.println(board.getBoardSurface(c1).getPieceFromSurface().getSymbol());
		
		
		
		IPlayer winner = goalPlugin.isOver(this);
		IPlayer currentPlayer = null;
		while(winner==null) {
			
			//currentPlayer = getNextPlayer(currentPlayer);
			
			referee.giveTurn(currentPlayer);
			
			for(IPlayer p:players) {
				System.out.println("Your turn: "+p.getPlayerName());
			p.takeTurn(view);
			view.printBoard();
			winner = goalPlugin.isOver(this);
			}
			
			currentPlayer = referee.getNextPlayer(currentPlayer);
		}
		System.out.println("Winner is "+winner.getPlayerName());


	}

	public void setGoalPlugin(IGoalPlugin goalPlugin) {
		this.goalPlugin = goalPlugin;
	}

	public static void main(String args[]) {
		int numberOfPlayer=2;
		int numberOfPieceForEachPlayer = 10;
		int column=25,row=20;
		IinitialCoordinates ic = new ChineseCheckerCoordinates(numberOfPlayer);
		//IinitialCoordinates ic = new CheckerCoordinates();
		GameCreator gc = new GameCreator(ic);
		gc.init(column, row, numberOfPlayer,numberOfPieceForEachPlayer);
		View view = new View(gc.getBoard());
		IGoalPlugin goal = new PiecesToTarget();
		Game game = new Game(view, gc.getBoard(), gc.getPlayers(),goal);

		game.start();

	}

	@Override
	public Map<IPlayer, List<Coordinate>> getPlayerFinishPair() {
		// TODO Auto-generated method stub
		return finalDestinationsForEachPlayer;
	}

	@Override
	public IBoardSurface[][] getBoard() {
		// TODO Auto-generated method stub
		return board.getWholeBoard();
	}
}
