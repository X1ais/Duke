package main;

import pieces.Piece;

public class Move {
	
	private int oldCol, oldRow;
	private int newCol, newRow;
	
	private Piece piece;
	private Piece capture;
	
	public Move(Board board, Piece piece, int newCol, int newRow) {
		
		this.oldCol = piece.getCol();
		this.oldRow = piece.getRow();
		this.setNewCol(newCol);
		this.setNewRow(newRow);
		
		this.setPiece(piece);
		
		this.setCapture(board.getPiece(newCol, newRow));
	}

	public int getNewCol() {
		return newCol;
	}

	public void setNewCol(int newCol) {
		this.newCol = newCol;
	}

	public int getNewRow() {
		return newRow;
	}

	public void setNewRow(int newRow) {
		this.newRow = newRow;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getCapture() {
		return capture;
	}

	public void setCapture(Piece capture) {
		this.capture = capture;
	}

}
