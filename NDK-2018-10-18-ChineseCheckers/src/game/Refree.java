package game;


import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Coordinate;
import board.IBoardSurface;
import goal.IGoalPlugin;
import move.IMovePlugin;
import move.IMoveRulePlugin;
import piece.IPiece;
import player.IPlayer;


public class Refree{
	private Board board;
	private List<IMovePlugin> movePlugins;
	private List<IMoveRulePlugin> moveRulePlugins;
	private List<IGoalPlugin> goalPlugins;
	
	public Refree(Board board) {
		movePlugins = new ArrayList<IMovePlugin>();
		moveRulePlugins = new ArrayList<IMoveRulePlugin>();
		this.board=board;
	}
	
	public void addMovePlugin(IMovePlugin plugin) {
		movePlugins.add(plugin);
	}
	
	public void addMoveRulePlugin(IMoveRulePlugin plugin) {
		moveRulePlugins.add(plugin);
	}
	
	//N
	public void putPieceToSquare(Coordinate destination,IPiece piece) {
		board.getBoardSurface(destination).addPiece(piece);
	}
	
	public boolean isCorrectMove(Coordinate source, Coordinate destination) {
		
		Coordinate difference = source.subtractFrom(destination);  
		System.out.println("reee : "+source);
		IBoardSurface sourceSurface = board.getBoardSurface(source);
		//IBoardSurface destinationSurface = board.getBoardSurface(destination);
		
		IPiece piece = sourceSurface.getPieceFromSurface();	// playerýn oynayacaðý tas
		
		Coordinate[] coords = piece.getMoveDirection();
		
		// cogu oyunlar icin ortak  nokta ---------------------
		
		boolean isTrueDirection = false;		
		
		for(Coordinate c: coords) 
			if(difference.equals(c)) 
				isTrueDirection = true;
		
		//----------------------------------------------------
		//gittigi yerde kare ve tas var mi
		
		
		// plugine sor
		
		for(IMovePlugin p : movePlugins) {
			isTrueDirection = p.checkMove(source, destination);  
			if(isTrueDirection)   // herhangibir kural saglaniyorsa true
				return true;
		}
		
		//----------------------------------------------------
		
		
		
		return isTrueDirection;

	}
	
	
	
	
	
/*	
	
	
	
	// board içinde ve oynanabilir alanda kordinat seçildi mi
	public boolean isValidCoordinate(Coordinate cord) {
		if(board.getBoardSurface(cord).equals(null)) {
			return false;
		}
		return true;
	}

*/	
	
	
	public IPiece getPieceFromCoordinate(Coordinate coord) { //tas kutudan mi yoksa boarddan mi gelecek kontrol edilecek(daha sonra)
		IBoardSurface square = board.getBoardSurface(coord);
		IPiece piece = square.getPieceFromSurface();
		square.removePiece();
		return piece;
	}
	
	
	
	public IMovePlugin getMovePlugin(String name) {
		for(IMovePlugin mp : movePlugins) {
			if(mp.getClass().equals(name+".class")) {
				return mp;
			}
		}
		return null;
	}
	
	public void searchRulePlugins(Coordinate source, Coordinate destination) {
		
		// 1 koordinat fark varsa SingleMove
		// 2 koordinat fark varsa JumpMove
		
		int rowDifference = Math.abs(destination.getRow() - source.getRow());
		int columnDifference = Math.abs(destination.getColumn()- source.getColumn());
	
		//SingleMove
		if((rowDifference == 1 && columnDifference ==1) || (rowDifference == 0 && columnDifference == 2)) {
			
			IMovePlugin mp = getMovePlugin("SingleMove");
			
		}
		
	}
	
	public void makeMove() {
		
	}
	
	public void giveTurn(IPlayer player) {
		
		// oyuncudan coord al
		
		// tas oyuncunun mu coord board icinde mi
		
		//if(sourceCoordinate )
		// coordlari kontrol et uygun move rule plugini bul
		// dest e gidebilir mi dolu bos -- rule a gore
		
		
		
		// coordlari pluginde kontrol et
		
		// 

	}
}
