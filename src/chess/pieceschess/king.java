package chess.pieceschess;

import boardgame.Board;
import chess.Color;
import chess.chesspiece;

public class king extends chesspiece {
    
    public king(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
        //para aparecer a letra k do rei
    }
    
}
