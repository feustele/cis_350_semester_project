public class Bishop extends Piece{
		 boolean isValidMove(Move m, Board b) {
			boolean helper = false;
			
			if ((m.dr != m.sr) || (m.dc != m.sc)){
				for (int i = 0; i < 8; i++) {
					if (((m.dr == (m.sr + i)) && (m.dc == (m.sc + i))) || ((m.sr == (m.dr + i)) && (m.sc == (m.dc + i)))||((m.dr == (m.sr - i)) && (m.dc == (m.sc + i))) || ((m.dr == (m.sr + i)) && (m.dc == (m.sc - i)))) {
						
						if ((m.dr == (m.sr + i)) && (m.dc == (m.sc + i))) {
							for (int j = 1; j < i; j++) {
								if (b.pieceAt(m.sr + j, m.sc + j) != null) {
									return helper;
								}
							}
							helper = true;
						}
						else if ((m.sr == (m.dr + i)) && (m.sc == (m.dc + i))) {
							for (int j = 1; j < i; j++) {
								if (b.pieceAt(m.dr + j, m.dc + j) != null) {
									return helper;
								}
							}
							helper = true;
						}
						// MODIFIED FROM DEMO: MEANT TO ALLOW PIECES TO MOVE DOWN AND LEFT
						// if (b.pieceAt(m.dr + j, m.dc - j) != null) {
						      //return helper;
						else if ((m.dr == (m.sr + i)) && (m.dc == (m.sc - i))) {
							for (int j = 1; j < i; j++) {
								if (b.pieceAt(m.dr + j, m.sc - j) != null) {
									return helper;
								}
							}
							helper = true;
						}
						// MODIFIED FROM DEMO: MEANT TO ALLOW PIECES TO MOVE UP AND LEFT
						// if (b.pieceAt(m.dr + j, m.dc - j) != null) {
					      		//return helper;
						else if ((m.dr == (m.sr - i)) && (m.dc == (m.sc + i))) {
							for (int j = 1; j < i; j++) {
								if (b.pieceAt(m.sr - j, m.dc + j) != null) {
									return helper;
								}
							}
							helper = true;
						}
						else {
							return false;
						}
					}
				}
			}
			return helper;
		 }


			String getType() {
				return "Bishop";
			}
	}