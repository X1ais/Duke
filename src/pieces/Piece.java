package pieces;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Board;

public class Piece {
	
	private int col;
	private int row;
	protected int spriteXPos, spriteYPos;
	private int xPos, yPos;
	
	protected boolean isLightPiece;
	protected boolean isFlipped = false;
	private String name;
	// private int value;
	
	private String spriteSheetPath = "/duke_pieces_sheet.png";
	
	BufferedImage sheet;
	{
	
		try {
			sheet = ImageIO.read(getClass().getResource(spriteSheetPath));
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	protected Image sprite;
	protected Board board;
	
	protected int sheetScale = sheet.getWidth()/9;
	
	public Piece(Board board) {
		this.board = board;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.drawImage(sprite, xPos, yPos, null);
	}
	
	
	

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public int getYPos() {
		return xPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	public boolean isLightPiece() {
		return isLightPiece;
	}

	public void setLightPiece(boolean isLightPiece) {
		this.isLightPiece = isLightPiece;
	}

	public boolean isFlipped() {
		return isFlipped;
	}

	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
