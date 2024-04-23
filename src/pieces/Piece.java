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
	
	protected String spriteSheetPath = "/duke_pieces_sheet.png";
	
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
	
}
