package chess;


import boardgame.Board;
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
    // retorna matriz de peças do meu xadrez
    chesspiece[][] mat = new chesspiece[board.getRows()][board.getColumns()];

    for (int i = 0; i < board.getRows(); i++) {
        for (int j = 0; j < board.getColumns(); j++) {
            // Usa o método piece da sua variável board
            mat[i][j] = (chesspiece) board.piece(i, j);
        }
    }
    return mat;
}

private void placeNewPiece(char column, int row, chesspiece piece) {
    //colocar nova peça no tabuleiro
    board.placePiece(piece, new ChessPosition(column, row).toPosition());
}


  private void initialSetup() {
    //colocar as peças no tabuleiro
   
    placeNewPiece('b', 6, new Rook(board, Color.WHITE));
    placeNewPiece('e', 8, new king(board, Color.BLACK));
    placeNewPiece('e', 1, new king(board, Color.WHITE));

  }

}