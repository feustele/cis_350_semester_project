public class King extends Piece{
	public static final int SIZE = 8;

	boolean isValidMove(Move m, Board b) {

		if ((m.dr == (m.sr + 1) && m.dc == m.sc) || (m.dr == (m.sr - 1) && m.dc == m.sc)) {
			return true;
			// can move forward and backward one space horozontally
		}		
		else if ((m.dr == m.sr && (m.dc + 1) == m.sc) || (m.dr == m.sr && (m.dc - 1) == m.sc)){
			return true;
			// can move forward and backward one space laterally
		}
		else if ((m.dr == (m.sr + 1) && (m.sc + 1) == m.dc)||(m.dr == (m.sr - 1) && (m.sc - 1) == m.dc)) {
			return true;
			// can move diagonally northeast and southwest one space
		}
		else if (((m.sr + 1) == m.dr && m.dc == (m.sc - 1))||((m.sr - 1) == m.dr && m.dc == (m.sc + 1))) {
			return true;
			// can move diagonally northwest and southeast one space
		}
		else {
			return false;
		}
//		if (b.isUnderAttack(SIZE, SIZE, SIZE){
//			if ((m.dr == (m.sr + 1) && m.dc == m.sc) || (m.dr == (m.sr - 1) && m.dc == m.sc)) {
//				return true;
//				// can move forward and backward one space horozontally
//			}		
//			else if ((m.dr == m.sr && (m.dc + 1) == m.sc) || (m.dr == m.sr && (m.dc - 1) == m.sc)){
//				return true;
//				// can move forward and backward one space laterally
//			}
//			else if ((m.dr == (m.sr + 1) && (m.dc + 1) == m.sc)||(m.dr == (m.sr - 1) && (m.dc - 1) == m.sc)) {
//				return true;
//				// can move diagonally northeast and southwest one space
//			}
//			else if (((m.dr + 1) == m.sr && m.dc == (m.sc + 1))||((m.dr - 1) == m.sr && m.dc == (m.sc - 1))) {
//				return true;
//				// can move diagonally northwest and southeast one space
//			}
//			else {
//				return false;
//			}
//		}
	}
	// king cannot move into a check

	String getType() {
		return "King";
	}
	
	
}

