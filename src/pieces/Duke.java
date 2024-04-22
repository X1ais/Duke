package pieces;

import java.awt.image.BufferedImage;

import main.Board;

public class Duke extends Piece {

	public Duke(Board board, int col, int row, boolean isLightPiece, boolean isFlipped) {
		super(board);
		this.col = col;
		this.row = row;
		this.xPos = col*board.tileSize;
		this.yPos = row*board.tileSize;
		this.isLightPiece = isLightPiece;
		this.spriteXPos = 5;
		this.spriteYPos = 0;
		
		this.setName("Duke");
		
		//this.sprite = sheet.getSubimage(spriteXPos*sheetScale,(isLightPiece ? spriteYPos : (spriteYPos + 4) * sheetScale) + (isFlipped ? 1 : 0) , sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
		this.sprite = sheet.getSubimage(5*sheetScale,0 , sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
	}

}
