package chess;

import boardgame.Board;
import boardgame.Piece;

public class chesspiece extends Piece{
    
    private Color color;

    public chesspiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
//
    public Color getColor() {
        return color;
    }

   
    
}
