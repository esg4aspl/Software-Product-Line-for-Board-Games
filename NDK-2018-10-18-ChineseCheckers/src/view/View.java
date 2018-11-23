package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.Board;

import board.Coordinate;
import board.IBoardSurface;


public class View {
	private Board board;
	private String alphabetString = "ABCDEFGHIJKLMNOPQRSTUWXYZ";
	private final char[] alphabet = alphabetString.toCharArray();
	Scanner scan ;
	public View(Board board) {
		this.board = board;
		scan = new Scanner(System.in);
	}
	
	public List<String> getPlayerNames(int numberOfPlayers){
		
		List<String> playerNames = new ArrayList<String>(); 
		for(int i = 0; i<numberOfPlayers; i++) {
			System.out.println("Enter player"+(i+1)+" name: ");
			playerNames.add(scan.nextLine());
		}
		return playerNames;
	}
	
	public Coordinate getCoordinateFromUser(String sourceOrDestination) {
		System.out.println("Enter "+sourceOrDestination+" Column A to Z: ");
		String s = scan.nextLine();
		int column = alphabetString.indexOf(s);
		System.out.println("Enter "+sourceOrDestination+" Column 1 to "+board.getRowSize()+": ");
		int row = Integer.parseInt(scan.nextLine());
		System.out.println(new Coordinate(column, row-1));
		return new Coordinate(column, row-1);
	}
	
	public void printBoard() {
		heplerPrint();
		IBoardSurface[][] wholeBoard = board.getWholeBoard();
		for(int i=0; i<wholeBoard.length; i++) {
			if(i<9)
				System.out.print(i+1+" : ");
			else
				System.out.print(i+1+": ");
			for(int j =0; j<wholeBoard[0].length; j++) {
				if(wholeBoard[i][j]!=null) {
					if(wholeBoard[i][j].getPieceFromSurface()!=null)
						System.out.print(" "+wholeBoard[i][j].getPieceFromSurface().getSymbol()+" ");
					else
						System.out.print(" O ");
				}else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
	
	private void heplerPrint() {
		System.out.print("    ");
		for(int i=0; i<board.getColumnSize(); i++) {
			System.out.print(" "+alphabet[i]+" ");
		}
		System.out.println("");
	}
	
	
	
	/*
	public static void main(String args[]) {
		
		Board b = new Board(25,20);
		IinitialCoordinates gameable = new ChineseCheckerCoordinates(4);
		//IinitialCoordinates gameable = new CheckerCoordinates();
		List<Coordinate> coord = gameable.getGameableCoordinates();
		
		for(Coordinate c: coord) {
			//System.out.println(c.getColumn() + " "+c.getRow());
			b.addSurface(c, new BoardSurface());
		}
		
		List<List<Coordinate>> initialCoord = gameable.getPlayerPieceInitialPositionsPair();
		String[] st = {"#","0","-","+","%","*"};
		int i = 0;
		for(List<Coordinate> l: initialCoord) {
			for(Coordinate c : l) {
				IBoardSurface surface = b.getBoardSurface(c);
				surface.addPiece(new Piece(Color.BLACK, st[i]));
			}
			i++;
		}
		
		View v = new View(b);
		v.printBoard();
	}*/
	
}
