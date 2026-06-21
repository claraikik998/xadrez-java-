package chess;

import boardgame.Board;

public class ChessMatch {
    
private Board board;
public ChessMatch() {
    board = new Board(8, 8);
    //informo que meu tabuleiro é 8 por 8
}

public chesspiece[][] getPieces() {
//retorna matriz de peças do meu xadrez
    chesspiece[][] mat = new chesspiece[board.getRows()][board.getColumns()];

    for (int i=0; i<board.getRows(); i++) {
        for (int j=0; j<board.getColumns(); j++) {
            mat[i][j] = (chesspiece) board.piece(i, j);
        }
    }
    return mat;
}

}
