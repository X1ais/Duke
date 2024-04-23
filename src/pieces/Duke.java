package pieces;

import java.awt.image.BufferedImage;

import main.Board;

public class Duke extends Piece {

	public Duke(Board board, int col, int row, boolean isLightPiece) {
		super(board);
		this.setCol(col);
		this.setRow(row);
		this.setXPos(col*board.TILE_SIZE);
		this.setYPos(row*board.TILE_SIZE);
		this.setLightPiece(isLightPiece);
		//this.setFlipped(false);
		this.spriteXPos = 5;
		this.spriteYPos = 1;
		
		this.setName("Duke");


		this.sprite = sheet.getSubimage(spriteXPos*sheetScale,(isLightPiece ? spriteYPos: (spriteYPos + 4)) * sheetScale , sheetScale, sheetScale).getScaledInstance(board.TILE_SIZE, board.TILE_SIZE, BufferedImage.SCALE_SMOOTH);

			//this.sprite = sheet.getSubimage(spriteXPos*sheetScale,((isLightPiece ? spriteYPos+1 : (spriteYPos + 5) * sheetScale)), sheetScale, sheetScale).getScaledInstance(board.TILE_SIZE, board.TILE_SIZE, BufferedImage.SCALE_SMOOTH);

		//this.sprite = sheet.getSubimage(5*sheetScale, 0, sheetScale, sheetScale).getScaledInstance(board.TILE_SIZE, board.TILE_SIZE, BufferedImage.SCALE_SMOOTH);
	}
	
	public void updateSprite() {
		this.sprite = sheet.getSubimage(spriteXPos*sheetScale,((isLightPiece() ? spriteYPos: (spriteYPos + 4))+(isFlipped()?1:0)) * sheetScale , sheetScale, sheetScale).getScaledInstance(board.TILE_SIZE, board.TILE_SIZE, BufferedImage.SCALE_SMOOTH);
	}

}
