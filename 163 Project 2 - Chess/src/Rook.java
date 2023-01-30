public class Rook extends Piece{
		 boolean isValidMove(Move m, Board b) {
			boolean helper = false;
			// to do: fix block 
			if (m.dr == m.sr) {
				if (m.dc - m.sc > 0) {
					for (int j = 1; j < (m.dc - m.sc); j++) {
						if (b.pieceAt(m.sr, m.sc + j) != null) {
								return helper;
						}
					}
					helper = true;
				}
				// MODIFIED FROM DEMO:
				else if (m.dc - m.sc < 0){
					for (int j = 1; j < (m.sc - m.dc); j--) {
//						if (b.pieceAt(m.sr, m.sc - j) != null) {
//								return helper;
						if (b.pieceAt(m.dr, m.dc - j) != null) {
							return helper;
						}
					}
					helper = true;
				}
				else {
					return false;
				}
			}
			else if (m.dc == m.sc){
				if (m.dr - m.sr > 0) {
					for (int j = 1; j < (m.dr - m.sr); j++) {
						if (b.pieceAt(m.sr + j, m.sc) != null) {
								return helper;
						}
					}
					helper = true;
				}	
				// MODIFIED FROM DEMO:
				else if (m.dr - m.sr < 0){
					for (int j = 1; j < (m.sc - m.dc); j--) {
//						if (b.pieceAt(m.sr - j, m.sc) != null) {
//								return helper;
						if (b.pieceAt(m.dr - j, m.dc) != null) {
							return helper;
						}
					}
					helper = true;
				}
				else {
					return false;
				}
			}	
			else {
				helper = false;
			}
			return helper;
		 }

			String getType() {
				return "Rook";
			}
	}