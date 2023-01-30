public class Knight extends Piece{
		 boolean isValidMove(Move m, Board b) {
			if ((m.dr == (m.sr + 2) || m.dr == (m.sr - 2) || (m.dr + 2) == m.sr || (m.dr - 2) == m.sr)){
				if ((m.dc == (m.sc + 1) || m.dc == (m.sc - 1) || (m.dc + 1) == m.sc|| (m.dc - 1) == m.sc)){
					return true;
				}
				else {
					return false;
				}
			}
			else if (((m.dr == (m.sr + 1) || m.dr == (m.sr - 1) || (m.dr + 1) == m.sr|| (m.dr - 1) == m.sr))){
				if((m.dc == (m.sc + 2) || m.dc == (m.sc - 2) || (m.dc + 2) == m.sc|| (m.dc - 2) == m.sc)){
					return true;
				}
				else {
					return false;
				}
				
			}
			else {
				return false;
			}
}



		@Override
		String getType() {
			return "Knight";
		}
}
