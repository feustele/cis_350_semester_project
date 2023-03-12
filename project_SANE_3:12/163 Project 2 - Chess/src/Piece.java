
public abstract class Piece {
	// used to define which pieces a player can and cannot move. 
		abstract boolean isValidMove(Move m, Board b);
		public static final int WHITE = 0;
		public static final int BLACK = 1;
		
		public int color;
		void setColor(int color) { this.color = color; }
		int getColor() { return color; }
		
		abstract String getType();
	}
