package chess;


import boardgame.Board;
import boardgame.Position;
import chess.Color;
import chess.pieceschess.Rook;
import chess.pieceschess.king;


public class ChessMatch {
    
private Board board;
//construtor
public ChessMatch() {
    board = new Board(8, 8);
        initialSetup();
        //chama o metodo para colocar as peças no tabuleiro
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
  private void initialSetup() {
    //colocar as peças no tabuleiro
    board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
    board.placePiece(new king(board, Color.BLACK), new Position(0, 4));

  }
}