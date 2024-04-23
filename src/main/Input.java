package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

import pieces.Piece;

public class Input implements MouseListener, MouseMotionListener {
	
	private Board board;
	
	public Input(Board board) {
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int col = e.getX() / board.TILE_SIZE;
		int row = e.getY() / board.TILE_SIZE;
		
		Piece pieceXY = board.getPiece(col, row);
		if (Objects.nonNull(pieceXY)) {
			board.setSelectedPiece(pieceXY);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		int col = e.getX() / board.TILE_SIZE;
		int row = e.getY() / board.TILE_SIZE;
		
		if(Objects.nonNull(board.getSelectedPiece())) {
			Move move = new Move(board, board.getSelectedPiece(), col, row);
			
			if(board.isValidMove(move)) {
				board.makeMove(move);
				
				if(board.getSelectedPiece().isFlipped()) {
					board.getSelectedPiece().setFlipped(false);
				} else {
					board.getSelectedPiece().setFlipped(true);
				}
				board.getSelectedPiece().updateSprite();
				
				System.out.println(board.getSelectedPiece().isFlipped());

			} else {
				board.getSelectedPiece().setXPos(board.getSelectedPiece().getCol()*board.TILE_SIZE);
				board.getSelectedPiece().setYPos(board.getSelectedPiece().getRow()*board.TILE_SIZE);
			}
		}
		
		board.repaint();
		
		board.setSelectedPiece(null);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(Objects.nonNull(board.getSelectedPiece())) {
			board.getSelectedPiece().setXPos(e.getX() - board.TILE_SIZE / 2);
			board.getSelectedPiece().setYPos(e.getY() - board.TILE_SIZE / 2);
			
			board.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
