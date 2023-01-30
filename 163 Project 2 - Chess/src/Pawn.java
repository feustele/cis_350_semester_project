public class Pawn extends Piece{
	int turnCounter = 0;
		 boolean isValidMove(Move m, Board b) {
			 
			boolean helper = false;
			
			// if it is the first turn for either the black or white player	
			// CORRECTED FROM DEMO: PAWNS HAD THE ABILITY TO MOVE FORWARD TO CAPTURE. NO LONGER THE CASE.
			if ((b.pieceAt(m.dr, m.dc) == null) && ((m.dr == (m.sr + 1) && m.dc == m.sc) ||( m.dr == (m.sr - 1) && m.dc == m.sc) || (turnCounter == 0))) {
				if (((m.dr == (m.sr + 2) && m.dc == m.sc) || ((m.dr == (m.sr - 2) && m.dc == m.sc)))) {
					turnCounter++;
					helper = true;
				}
				else if ((m.dr == (m.sr + 1) && m.dc == m.sc) || b.pieceAt(m.sr, m.sc) != null && b.pieceAt(m.sr, m.sc).getColor() == Piece.BLACK && (m.dr == (m.sr + 1) && m.dc == m.sc)) {
					turnCounter++;
					helper = true;
				}
				else if (b.pieceAt(m.sr, m.sc) != null && b.pieceAt(m.sr, m.sc).getColor() == Piece.WHITE) {
					if ( m.dr == (m.sr - 1) && m.dc == m.sc) {
						turnCounter++;
						helper = true;
					}
					else {
						helper = false;
					}
				}
				else {
					helper = false;
				}

		 	}
			else {
			// if not	
				if (((b.pieceAt(m.dr, m.dc) != null) && (m.dr == (m.sr + 1) && m.dc == (m.sc + 1)))) {
					helper = true;
					turnCounter ++;
				}
				else if ((b.pieceAt(m.dr, m.dc) != null) && (m.dr == (m.sr + 1) && m.dc == (m.sc - 1))) {
					helper = true;
					turnCounter ++;
				}
				else if ((b.pieceAt(m.dr, m.dc) != null) && (m.dr == (m.sr - 1) && m.dc == (m.sc + 1))) {
					helper = true;
					turnCounter ++;
				}
				else if ((b.pieceAt(m.dr, m.dc) != null) && (m.dr == (m.sr - 1) && m.dc == (m.sc - 1))) {
					helper = true;
					turnCounter ++;
				}
				else {
					helper = false;
				}
			}
			return helper;
		}
		
		String getType() {
			return "Pawn";
		}
}