package pieces;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Board;

public class Piece {
	
	protected int col, row;
	protected int spriteXPos, spriteYPos;
	protected int xPos, yPos;
	
	protected boolean isLightPiece;
	protected boolean isFlipped;
	protected String name;
	protected int value;
	
	protected String spriteSheetPath = "duke_pieces_sheet.png";
	protected Image sprite;
	protected Board board;
	
	BufferedImage sheet;
	{
	
		try {
			sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream(spriteSheetPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public boolean isLightPiece() {
		return isLightPiece;
	}
	public void setLightPiece(boolean isLightPiece) {
		this.isLightPiece = isLightPiece;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSpriteSheetPath() {
		return spriteSheetPath;
	}
	public BufferedImage getSheet() {
		return sheet;
	}
	public void setSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	
	
	
}
