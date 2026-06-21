package chess.pieceschess;
//torre
import boardgame.Board;
import chess.Color;
import chess.chesspiece;

public class Rook extends chesspiece {
    //construtor repassa os parametros para a classe maior
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
        //para aparecer a letra r da torre
    }
    
}
