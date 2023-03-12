import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PiecesTest {

	@Test
	void testisValidMoveBishop() {
		Board b = new Board();
		Bishop bishop = new Bishop();
		b.placePiece(bishop, 0, 0);
		
		assertTrue(bishop.getType() == "Bishop");
		
		Move A = new Move();
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(bishop.isValidMove(A, b));
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 5;
		A.dc = 5;
		
		assertTrue(bishop.isValidMove(A, b));
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 5;
		A.dr = 5;
		
		assertTrue(bishop.isValidMove(A, b));
		
		Pawn p = new Pawn();
		b.placePiece(p, 6,6);
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 5;
		A.dr = 5;
		
		assertFalse(bishop.isValidMove(A, b));
		
		A.sc = 5;
		A.sr = 5;
		A.dc = 7;
		A.dr = 7;
		
		assertFalse(bishop.isValidMove(A, b));

		A.sc = 8;
		A.sr = 8;
		A.dc = 1;
		A.dr = 1;
		
		assertFalse(bishop.isValidMove(A, b));
		
		Board b1 = new Board();
		Bishop bishop1 = new Bishop();
		b1.placePiece(bishop1, 1, 1);
		
		A.sc = 1;
		A.sr = 1;
		A.dr = 2;
		A.dc = 0;
		
		assertTrue(bishop1.isValidMove(A, b1));
		
		A.sc = 1;
		A.sr = 1;
		A.dr = 0;
		A.dc = 2;
		
		assertTrue(bishop1.isValidMove(A, b1));
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 5;
		A.dr = 5;
		
		assertTrue(bishop1.isValidMove(A, b1));
		
		Pawn p1 = new Pawn();
		b1.placePiece(p1, 6, 4);
		
		A.sc = 7;
		A.sr = 5;
		A.dr = 5;
		A.dc = 7;
		
		assertFalse(bishop1.isValidMove(A, b1));
		
	}
	@Test
	
	void testisValidMoveQueen() {
		Board b = new Board();
		Queen q = new Queen();
		b.placePiece(q, 0, 0);
		
		assertTrue(q.getType() == "Queen");
		
		Move A = new Move();
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(q.isValidMove(A, b));
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 5;
		A.dc = 5;
		
		assertTrue(q.isValidMove(A, b));
		
		Pawn p = new Pawn();
		b.placePiece(p, 6,6);
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 5;
		A.dr = 5;
		
		assertFalse(q.isValidMove(A, b));

		A.sc = 8;
		A.sr = 8;
		A.dc = 1;
		A.dr = 1;
		
		assertFalse(q.isValidMove(A, b));
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(q.isValidMove(A, b));
		
		
		A.sc = 7;
		A.sr = 4;
		A.dc = 6;
		A.dr = 5;
		assertTrue(q.isValidMove(A, b));
	}
	
	@Test
	void testisValidMoveRook() {
		Board b = new Board();
		Rook r = new Rook();
		b.placePiece(r, 0, 0);
		
		assertTrue(r.getType() == "Rook");
		
		Move A = new Move();
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(r.isValidMove(A, b));
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 0;
		A.dc = 5;
		
		assertTrue(r.isValidMove(A, b));
		
		Pawn p = new Pawn();
		b.placePiece(p, 7,6);
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 5;
		A.dr = 7;
		
		assertFalse(r.isValidMove(A, b));

	}
	@Test
	void testisValidMovePawn() {
		
		Board b = new Board();
		Pawn p = new Pawn();
		p.setColor(Piece.WHITE);
		b.placePiece(p, 0, 0);
		
		assertTrue(p.getType() == "Pawn");
		
		Move A = new Move();
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(p.isValidMove(A, b));
		

		A.sc = 1;
		A.sr = 1;
		A.dc = 1;
		A.dr = 2;
		
		assertTrue(p.isValidMove(A, b));
		p.turnCounter = 6;
		
		b.placePiece(new Pawn(), 7, 7);
		
		A.sc = 6;
		A.sr = 6;
		A.dc = 7;
		A.dr = 7;
		
		b.removePiece(7, 7);
		
		assertFalse(p.isValidMove(A, b));
		p.turnCounter = 6; 
		
		A.sc = 1;
		A.sr = 1;
		A.dc = 1;
		A.dr = 2;
		
		assertTrue(p.isValidMove(A, b));
//		Modified my pawn capture method in the 11th hour. These tests passed prior but no longer do. 
		
	}
	@Test
	void testisValidMoveKnight() {
		Board b = new Board();
		Knight k = new Knight();
		b.placePiece(k, 0, 0);
		
		assertTrue(k.getType() == "Knight");
		
		Move A = new Move();
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(k.isValidMove(A, b));
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 1;
		
		assertTrue(k.isValidMove(A, b));
		
		Pawn p = new Pawn();
		b.placePiece(p, 6,6);
		
		A.sc = 0;
		A.sr = 0;
		A.dc = 1;
		A.dr = 2;
		
		assertTrue(k.isValidMove(A, b));

		A.sc = 1;
		A.sr = 1;
		A.dc = 3;
		A.dr = 2;
		
		assertTrue(k.isValidMove(A, b));
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 0;
		A.dr = 8;
		
		assertFalse(k.isValidMove(A, b));

		A.sc = 0;
		A.sr = 0;
		A.dc = 7;
		A.dr = 8;
		
		assertFalse(k.isValidMove(A, b));
		
	}
	@Test
	void testisValidMoveKing() {
		Board b = new Board();
		King king = new King();
		b.placePiece(king, 0, 0);
		
		assertTrue(king.getType() == "King");
		
		Move A = new Move();
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 2;
		A.dc = 5;
		
		assertFalse(king.isValidMove(A, b));
		
		A.sc = 0;
		A.sr = 0;
		A.dr = 0;
		A.dc = 1;
		
		assertTrue(king.isValidMove(A, b));
		
		Pawn p = new Pawn();
		b.placePiece(p, 6,6);
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 6;
		A.dr = 7;
		
		assertTrue(king.isValidMove(A, b));

		A.sc = 8;
		A.sr = 8;
		A.dc = 8;
		A.dr = 7;
		
		assertTrue(king.isValidMove(A, b));
		
		A.sc = 7;
		A.sr = 7;
		A.dc = 6;
		A.dr = 6;
		
		assertTrue(king.isValidMove(A, b));

		A.sc = 7;
		A.sr = 7;
		A.dc = 8;
		A.dr = 6;
		
		assertTrue(king.isValidMove(A, b));
		
		
	}


}
