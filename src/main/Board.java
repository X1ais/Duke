package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JPanel;

import pieces.Duke;
import pieces.Piece;

@SuppressWarnings("serial")
public class Board extends JPanel{

	public final int TILE_SIZE = 120;
	public final static int COLUMNS = 6;
	public final static int ROWS = 6;
	
	private ArrayList<Piece> pieceList = new ArrayList<>();
//	private Color light = new Color(228,203,175);
//	private Color dark = new Color(136,83,50);
	private Color boardColor = new Color(250,235,225);
	
	private Piece selectedPiece;
	
	private Input input = new Input(this);	

	public Board() {
		this.setPreferredSize(new Dimension(COLUMNS*TILE_SIZE, ROWS*TILE_SIZE));
		
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
		
		addPieces();
	}
	
	
	public Piece getPiece(int col, int row) {
		
		for (Piece p : pieceList) {
			if(p.getCol() == col && p.getRow() == row) {
				return p;
			}
		}
		return null;
	}
	
	
	public void addPieces() {
		pieceList.add(new Duke(this, 2, 0, true));
		pieceList.add(new Duke(this, 2, 5, false));
	}
	
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				g2d.setColor(boardColor);
				g2d.fillRect(c*TILE_SIZE, r*TILE_SIZE, TILE_SIZE, TILE_SIZE);
				g2d.setColor(Color.black);
				g2d.drawRect(c*TILE_SIZE, r*TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}
		
		for (Piece piece : pieceList) {
			piece.paint(g2d);
		}
	}


	public Piece getSelectedPiece() {
		return selectedPiece;
	}


	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}


	public void capture(Move move) {
		pieceList.remove(move.getCapture());
	}

	
	

	public void makeMove(Move move) {
		move.getPiece().setCol(move.getNewCol());
		move.getPiece().setRow(move.getNewRow());
		move.getPiece().setXPos(move.getNewCol()*TILE_SIZE);
		move.getPiece().setYPos(move.getNewRow()*TILE_SIZE);
		
		capture(move);
	}
	

	public boolean isValidMove(Move move) {
		
		if(sameTeam(move.getPiece(), move.getCapture())) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean sameTeam(Piece p1, Piece p2) {
		if(Objects.isNull(p1) || Objects.isNull(p2)) {
			return false;
		}
		
		return p1.isLightPiece() == p2.isLightPiece();
	}
	
	
}
