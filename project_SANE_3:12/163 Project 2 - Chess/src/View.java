import java.util.Scanner;

public class View {
	//shows the introduction text and gets the game type from the player
	Scanner scnr = new Scanner(System.in);
	String [] columnLetter = {"A","B","C","D","E","F","G","H"};
	String gameType;
	
	final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	
	final String ANSI_WHITE = "\u001B[37m";
	final String ANSI_BLACK = "\u001B[30m";
	
	final String ANSI_RESET = "\u001B[0m";
	
	public void showIntroText(){
		System.out.println("WELCOME TO CHESS!");
		System.out.println("INPUT 'P' FOR VERSUS PLAYER, 'C' FOR VERSUS COMPUTER.");
		gameType = scnr.next();
		System.out.println("GENERATING BOARD...");
	}
	
	public void showBoard(Board board) {
		// prints the board (in color!)
		System.out.println();
		System.out.println("   " + columnLetter[0] + " " + columnLetter[1] + " " + columnLetter[2] + " " + columnLetter[3] + " " + columnLetter[4] + " " + columnLetter[5] + " " + columnLetter[6] + " " + columnLetter[7]);
		for (int r = 0; r < Board.SIZE; r++) {
			System.out.print(9-(r+1) + " ");
			for (int c = 0; c < Board.SIZE; c++) {
				Piece p = board.pieceAt(r, c);
				if (p == null) {
					System.out.print(" .");
				}
				else {
					if (p.getColor() == 0) {
						System.out.print( " " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + pieceToString(p) + ANSI_RESET);
						
					}
					else {
						System.out.print(" " + ANSI_BLACK_BACKGROUND + ANSI_WHITE + pieceToString(p) + ANSI_RESET);
						
					}
				}
			}
			System.out.println();
			
		}
		System.out.println();
	}
	
	Move getMove() {
		// gets the move from the player
		System.out.println("What is the location of the piece you'd like to move?");
		String word1 = scnr.next();
		word1 = word1.toUpperCase();
		
		System.out.println("Where would you like to move it to?");
		String word2 = scnr.next();
		word2 = word2.toUpperCase();
		
		return makeMove(word1, word2);
	}
	
	Move makeMove(String word1, String word2) {
		// transmutes the given move into usable array data
		Move m = new Move();		
				// split words 1 and 2 into an array after converting letter to integer
		try {
			if (word1.length() == 2 && word2.length() == 2) {
				m.sc = columnLetterToInt(word1.charAt(0));
				m.sr = rowNumberToInt(word1.charAt(1));
				m.dc = columnLetterToInt(word2.charAt(0));
				m.dr = rowNumberToInt(word2.charAt(1));
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Sorry! It doesn't look like those are valid coordinates. Please input coordinates in row number column letter format. (IE, 3d, 7h.)");
		}
		return m;
	}
	
	int columnLetterToInt(char c) {
		// converts a given character to an integer value for the chessEngine to use

		int number = c - 'A';
		if (number < 8) { 
			return number;
		}
		return number;
	}
		
	int rowNumberToInt(char n) {
		// converts a given number to an integer value for the chessEngine to use
		int number = n - '1';
		if (number < 8) { 
			return 7 - number;
		}
		return number;
	}
		
	String pieceToString(Piece p) {
		// converts the given piece into a display character.
			if (p.getType() == "Pawn") {
				return "p";
			}
			else if (p.getType() == "King") {
				return "K";
			}
			else if (p.getType() == "Queen") {
				return "Q";
			}
			else if (p.getType() == "Rook") {
				return "R";
			}
			else if (p.getType() == "Bishop") {
				return "B";
			}	
			else {
				return "N";
			}
		}
	
	 String getGameMode(){
		// used to implement PVE for the player to use
		try {
			if (gameType.toUpperCase().equals("P")) {
				return "P";
			}
			else if (gameType.toUpperCase().equals("C")){
				return "C";
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e) {
			return ("Please enter P for versus player or C for versus computer.");
		}
	}
}
