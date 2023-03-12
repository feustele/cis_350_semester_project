import java.util.Random;

public class chessEngine{

	Board board;
	View view;
	
	public int currentPlayerColor;
	private int winnerColor;
	public int turnCounter = 0;
	
	public int currentPlayerColor(int color) {
		// playerColor can either be white (0) or black (1). TO DO: add test that prevents player from using any number other than 0 or 1.

		try {
			if (color == 0) {
				currentPlayerColor = Piece.WHITE;
			}
			else if (color == 1) {
				currentPlayerColor = Piece.BLACK;
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("No such color exists.");
		}
			return currentPlayerColor;
		}
	
	public int winnerColor() {
		// returns the player who has checkmated unless no player has checkmated; then it returns -1.

		winnerColor =  -1;
		return winnerColor;
	}
	
	public void gameAI() {
		//	Simple AI which randomly tries pieces until it can build a valid move.
		//	To clarify- my initial goal was to copy Deep Blue's first game against Garry Kasparov
		// as in it would only make the moves Deep Blue made. I wasn't about to try and duplicate
		// a chess engine so complicated it would probably melt my laptop.
		//it was not intuitive. 

		if (winnerColor()== -1) {
			while (currentPlayerColor == Piece.BLACK) {
				Random r = new Random();
				Move b = new Move();
				b.sr = r.nextInt(7);
				b.sc = r.nextInt(7);
				b.dc = r.nextInt(7);
				b.dr = r.nextInt(7);
				if (board.pieceAt(b.sr,b.sc) != null) {
					Piece c = board.pieceAt(b.sr,b.sc);
					Piece d = board.pieceAt(b.dr,b.dc);
					if (c.isValidMove(b, board) && c.getColor() == Piece.BLACK){
						if (d == null || d.getColor() == Piece.WHITE) {
							board.removePiece(b.sr, b.sc);
							board.placePiece(c, b.dr, b.dc);
							view.showBoard(board);
							turnCounter++;
							nextPlayer();
						}
					}
				}
			}
		}
	}
	
	public void gameLoop(){
		// flips to the next player, prints the board (calls view), gets a move from the player until they enter a 
		// legal one, makes the move, repeat until the game is over or the player resigns. Then print the winner of the game.
		if (view.getGameMode() == "P") {
			while (winnerColor() == -1) {
				view.showBoard(board);
				move(view.getMove());
			}
	    }
		// the pvp loop which takes inputs from both players
		
	    else if (view.getGameMode() == "C"){
	    	while (winnerColor() == -1) {
				view.showBoard(board);
				move(view.getMove());
				gameAI();
	    	}
	    }
		// the pve loop which takes input from one player and the computer
		
		if (winnerColor() != -1) {
			System.out.println(currentPlayerColor + "has achieved checkmate! Good game!");
		}
	}
	
	public void move(Move move){
		// defines what a move can be

		Piece p = board.pieceAt(move.sr, move.sc);
		
		try {
			if (p.getColor() == currentPlayerColor){
				if (p.isValidMove(move, board)){
					if ((board.pieceAt(move.dr, move.dc) == null) || (board.pieceAt(move.dr, move.dc).getColor() != currentPlayerColor)) {
						board.removePiece(move.sr, move.sc);
						board.placePiece(p, move.dr, move.dc);
						turnCounter++;
						nextPlayer();
					}
					else {
						throw new Exception();
					}
				}
				else {
					throw new Exception();
				}
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e){
			System.out.println("Sorry! That looks like an invalid move. Please try again!");
		}
		
	}
	
	public void nextPlayer(){
		// Displays whose turn it is. 

		try {
		if (currentPlayerColor == Piece.WHITE) {
			currentPlayerColor = Piece.BLACK;
			System.out.println("The next turn goes to: BLACK");
		}
		else if (currentPlayerColor == Piece.BLACK) {
			currentPlayerColor = Piece.WHITE;
			System.out.println("The next turn goes to: WHITE");
		}
		}
		catch (IllegalArgumentException e) {
			System.out.println("No such color exists.");
		}
	}
	
	public chessEngine() {
		// builds a board, sets the starting player as white, fills the board, and shows the intro text.
		board = new Board();
        board.placeAllPieces();
   
        currentPlayerColor = Piece.WHITE;
        
        view = new View();
        view.showIntroText();
	}
	
	public static void main(String args[]) {
		// main method. does what it says on the tin
		chessEngine c = new chessEngine();
		c.gameLoop();
	}
}
