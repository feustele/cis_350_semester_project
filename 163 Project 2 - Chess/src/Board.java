public class Board {
	chessEngine c;
	
	public static final int SIZE = 8;
	Piece[][] board = new Piece[SIZE][SIZE];
	// used to build board size
	
	public Board() {
		// creates an empty board where each space equals null.
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE ; j++) {
				board[i][j] = null ;
			}
		}
	}
	
	
	public Piece pieceAt(int r, int c){
		// finds the piece at the specified index and returns it.
		return board[r][c];
	}
	
	public int[] squareOf(Piece p){
		// would have been used for my checkmate method. Does work, but is unused.
		int[] k = {0,0};
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE ; j++) {
				if (board[i][j] == p) {
					k[0] = i;
					k[1] = j;
				}
			}
		}
		return k;
	}
	
	public void placePiece(Piece p, int r, int c) {	
		// sets the value of the given board index to the given piece.
		board[r][c] = p;
	}
	
	public void placeAllPieces() {
		// fills the board with pieces in the predetermined spaces with the predetermined colors.

		for (int i = 0; i < SIZE; i++) {
			Pawn Bp1 = new Pawn();
			Bp1.setColor(Piece.BLACK);
			placePiece(Bp1, 1, i);
		}
		// generates 8 black pawns
		
		for (int i = 0; i < SIZE; i++) {
			Pawn Wp1 = new Pawn();
			Wp1.setColor(Piece.WHITE);
			placePiece(Wp1, 6, i);
		}
		// generates 8 white pawns
		
		King Bk = new King();
		Bk.setColor(Piece.BLACK);
		placePiece(Bk,0,4);
		
		King Wk = new King();
		Wk.setColor(Piece.WHITE);
		placePiece(Wk,7,4);
		
		Queen Bq = new Queen();
		Bq.setColor(Piece.BLACK);
		placePiece(Bq,0,3);
		
		Queen Wq = new Queen();
		Wq.setColor(Piece.WHITE);
		placePiece(Wq,7,3);
		
		Rook BrQs = new Rook();
		BrQs.setColor(Piece.BLACK);
		placePiece(BrQs,0,7);
		
		Rook BrKs = new Rook();
		BrKs.setColor(Piece.BLACK);
		placePiece(BrKs,0,0);
		
		Rook WrQs = new Rook();
		WrQs.setColor(Piece.WHITE);
		placePiece(WrQs,7,0);
		
		Rook WrKs = new Rook();
		WrKs.setColor(Piece.WHITE);
		placePiece(WrKs,7,7);
		
		Bishop BbQs = new Bishop();
		BbQs.setColor(Piece.BLACK);
		placePiece(BbQs,0,2);
		
		Bishop BbKs = new Bishop();
		BbKs.setColor(Piece.BLACK);
		placePiece(BbKs,0,5);
		
		Bishop WbQs = new Bishop();
		WbQs.setColor(Piece.WHITE);
		placePiece(WbQs,7,2);
		
		Bishop WbKs = new Bishop();
		WbKs.setColor(Piece.WHITE);
		placePiece(WbKs,7,5);
		
		Knight BknQs = new Knight();
		BknQs.setColor(Piece.BLACK);
		placePiece(BknQs,0,1);
		
		Knight BknKs = new Knight();
		BknKs.setColor(Piece.BLACK);
		placePiece(BknKs,0,6);
		
		Knight WknQs = new Knight();
		WknQs.setColor(Piece.WHITE);
		placePiece(WknQs,7,1);
		
		Knight WknKs = new Knight();
		WknKs.setColor(Piece.WHITE);
		placePiece(WknKs,7,6);	
	}
// BEHOLD! My broken checkmate method.
// decided to go full lion king and say hakuna matata
	
//	public Piece kingFinder() {
//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE ; j++) {
//				Piece p = board[i][j];
//				if (p.getType() == "King" && p.getColor() != c.currentPlayerColor) {
//					return p;
//				}
//			}
//		}
//		return null;
//	}
//	// finds the other player's king on the board
//	
//	public boolean isCheck(int currentColor) {
//		Piece p = kingFinder();
//		Piece q; 
//	
//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE ; j++) {
//				q = this.pieceAt(i, j);
//				int k[] = squareOf(p);
//				Move r = new Move();
//				r.sr = i;
//				r.sc = j;
//				r.dr = k[0];
//				r.dc = k[1];
//				if ((q.getType() != "King" && p.getColor() != currentColor) && q.isValidMove(r, b)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	// checks to see if the other player's king is in check.
//	
//	public boolean isUnderAttack(int Kc, int Kr, int currColor) {
//		Piece q; 
//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE ; j++) {
//				Piece p = pieceAt(Kr, Kc);
//				q = this.pieceAt(i, j);
//				Move r = new Move();
//				r.sr = i;
//				r.sc = j;
//				r.dr = Kr;
//				r.dc = Kc;
//				if ((p.color != currColor) && (q.isValidMove(r, b))){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	// checks to see if the piece at the given space can be attacked
//	
//	public boolean block(int Kc, int Kr, int color) {
//		Piece q; 
//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE ; j++) {
//				Piece p = pieceAt(Kr, Kc);
//				
//				Move r = new Move();
//				r.sr = i;
//				r.sc = j;
//				r.dr = Kr;
//				r.dc = j;
//				
//				Move s = new Move();
//				s.sr = i;
//				s.sc = j;
//				s.dr = i;
//				s.dc = Kc;
//				
//				}
//			}
//		}
//		return false;
//	}
//	// returns true if a piece can block a given piece. false otherwise.
//	
//	public boolean isCheckmate(int color) {
//		if (isCheck(color) == false) {
//			return false;
//		}
//		else {
//			for (int i = 0; i < SIZE; i++) {
//				for (int j = 0; j < SIZE ; j++) {
//					Piece king = kingFinder();
//					int k[] = squareOf(kingFinder());
//					Move r = new Move();
//					r.sr = i;
//					r.sc = j;
//					r.dr = k[0];
//					r.dc = k[1];
//					Move s = new Move();
//					s.sr = k[0];
//					s.sc = k[1];
//					s.dr = i;
//					s.dc = j;
//					if (isUnderAttack(r.dc, r.dr, color)){
//						if (!king.isValidMove(s, b)) {
//							Piece h = pieceAt(i,j);
//							if (h.getColor() == color && h.isValidMove(r, b)) {
//								if(!canBlock(r.dc, r.dr, color)){
//									return true;
//								}
//							}
//						}
//						
//					}
//				}
//			}
//		}
//		return false;
//	}
//	// returns true if the game is in checkmate. Else, returns false.
	
	public Piece removePiece(int r, int c){
		Piece p = pieceAt(r,c);
		placePiece(null, r, c);
		return p;
	}
	// removes and returns the indexed piece.
	
}



