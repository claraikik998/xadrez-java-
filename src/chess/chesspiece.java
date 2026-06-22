package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class chesspiece extends Piece{
    
    private Color color;

    public chesspiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
//
    public Color getColor() {
        return color;
    }

   protected boolean isThereOpponentPiece(Position position) {
        chesspiece p = (chesspiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
    
}
