package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import pieces.Duke;
import pieces.Piece;

public class Board extends JPanel{

	public int tileSize = 120;
	
	int cols = 6;
	int rows = 6;
	
	ArrayList<Piece> pieceList = new ArrayList<>();
	Color light = new Color(228,203,175);
	Color dark = new Color(136,83,50);
	Color boardColor = new Color(158,132,109);
	

	public Board() {
		this.setPreferredSize(new Dimension(cols*tileSize, rows*tileSize));
		addPieces();
	}
	
	public void addPieces() {
		pieceList.add(new Duke(this, 2, 0, true, false));
	}
	
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				g2d.setColor(boardColor);
				g2d.fillRect(c*tileSize, r*tileSize, tileSize, tileSize);
				g2d.setColor(Color.black);
				g2d.drawRect(c*tileSize, r*tileSize, tileSize, tileSize);
			}
		}
		
		for (Piece piece : pieceList) {
			piece.paint(g2d);
		}
	}
	
	
}
