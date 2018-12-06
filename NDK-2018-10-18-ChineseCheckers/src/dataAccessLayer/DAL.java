package dataAccessLayer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import board.Coordinate;
import enums.Color;
import piece.IPiece;
import piece.Piece;
import java.util.*;

public class DAL {
	
	//JUST SIMPLE TEST 
	public static void main(String[] args) {
		DAL d = new DAL();
		d.getPlayerPiecesFromXML("Player1", 2);
	}
	
	/**
	 * This method is responsible for reading piece information from file
	 * for given playerName and how many player exists for this game
	 * numberOfPlayer parameter is required because this parameter use for indication
	 * of which file is chosen for read operation.
	 * @param playerName
	 * @param numberOfPlayer
	 * @return List<IPiece> for given playerName from file
	 */
	public List<IPiece> getPlayerPiecesFromXML(String playerName,int numberOfPlayer){
		List<IPiece> pieces = new ArrayList<IPiece>();
		Document document = null;
		//Set file name according to given parameter
		String fileName = "piecesFor"+numberOfPlayer+"PlayersGame.xml";
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(fileName);
		}catch (Exception ex) {
            System.out.println(ex.getMessage()); 
		}
		
		Element players = document.getDocumentElement();
		
		//get all nodes with name <Player> tags
		NodeList playerList = players.getElementsByTagName("Player");
		
		//is used to select desired player to pick pieces information
		Element desiredPlayer = getDesiredPlayer(playerList, playerName);
		//get all childs of desired player object from file
		
		NodeList pieceList = desiredPlayer.getElementsByTagName("Piece");
		createPiecesFromPieceList(pieceList,pieces);
		return pieces;
	}
	
	private void createPiecesFromPieceList(NodeList pieceList,List<IPiece> pieces) {
		for(int i=0; i<pieceList.getLength();i++) {
			Element currentPieceObject = (Element)pieceList.item(i);
			//get current piece object's color 
			String color = currentPieceObject.getElementsByTagName("Color").item(0).getTextContent();
			//get current piece object's name
			String name = currentPieceObject.getElementsByTagName("Name").item(0).getTextContent();
			//get current piece object's number of duplication
			String numberOfSamePieceAsString = currentPieceObject.getElementsByTagName("NumberOfSamePiece").item(0).getTextContent();
			int numberOfSamePiece = Integer.parseInt(numberOfSamePieceAsString);
			
			//get possible direction nodes in piece object
			//select first node because we know there is only one object with name PosibleNextMoveDirections
			Element possibleMoveDirection =(Element)currentPieceObject.getElementsByTagName("PossibleNextMoveDirections").item(0);

			String single = possibleMoveDirection.getElementsByTagName("Single").item(0).getTextContent();
			String jump= possibleMoveDirection.getElementsByTagName("Jump").item(0).getTextContent();
			String multiple = possibleMoveDirection.getElementsByTagName("Multiple").item(0).getTextContent();
			
			System.out.println(single+" - "+jump+" - "+multiple);
			
			//get all starting locations 
			Element startingLocations = (Element)currentPieceObject.getElementsByTagName("StartingLocations").item(0);
			NodeList locations = startingLocations.getElementsByTagName("Location");
			int row=-1;
			int column=-1;
			for(int j = 0; j<numberOfSamePiece;j++) {
				Element currentLocation  = (Element)locations.item(j);
				row = Integer.parseInt(currentLocation.getAttribute("row"));
				column = Integer.parseInt(currentLocation.getAttribute("column"));
				System.out.println(row +" - "+column); 
				IPiece piece = new Piece(Color.valueOf(color.toUpperCase()),name,new Coordinate(column, row));
				pieces.add(piece);
			}
		}
	}
	
	private Element getDesiredPlayer(NodeList playerList,String playerName) {
		//is used to select desired player to pick pieces information
		Element desiredPlayer  = null;
		for(int i = 0; i<playerList.getLength();i++) {
			Element currentPlayerObject = (Element)playerList.item(i);
			//In XML file get value between <Name> and </Name> tags for each player objects
			String playerNameFromFile =  currentPlayerObject.getFirstChild().getNextSibling().getTextContent();
			if(playerNameFromFile.equals(playerName)) {
				//if desired player name is equal to current object's name value
				//then set the desired player as current plater object
				desiredPlayer = currentPlayerObject;
				break;
			}
		}
		return desiredPlayer;
	}
}
