package chess;


import boardgame.Board;
import chess.pieceschess.Rook;
import chess.pieceschess.king;
import boardgame.Position;
import boardgame.Piece;


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

public boolean [][] possibleMoves(ChessPosition sourcePosition) {
    Position position = sourcePosition.toPosition();
    validateSourcePosition(position);
    return board.piece(position).possibleMoves();
}


public chesspiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
    //fazer o movimento das peças
    Position source = sourcePosition.toPosition();
    Position target = targetPosition.toPosition();
    validateSourcePosition(source);//ver se nessa posição tinha peça mesmo
    validateTargetPosition(source, target);//ver se a peça pode ir para essa posição
    Piece capturedPiece = makeMove(source, target);
    return (chesspiece) capturedPiece; // Usando a variável para sumir o aviso amarelo!
}
public  Piece makeMove(Position source, Position target) {
    //fazer o movimento das peças
    Piece p = board.removePiece(source);
    Piece capturedPiece = board.removePiece(target);
   //remove e captuta
    board.placePiece(p, target);
    //coloca a peça na posição de destino
    return capturedPiece;
}


public void validateSourcePosition(Position position) {
    //verificar se a posição de origem tem peça
    if (!board.thereIsAPiece(position)) {
        throw new ChessException("Não existe peça na posição de origem");
    }
    if (!board.piece(position).isThereAnyPossibleMove()) {
        throw new ChessException("Não existe movimentos possíveis para a peça escolhida");
    }
}

private void validateTargetPosition(Position source, Position target) {
    //verificar se a posição de destino é valida
    if (!board.piece(source).possibleMove(target)) {
        throw new ChessException("A peça escolhida não pode se mover para a posição de destino");
    }
}

private void placeNewPiece(char column, int row, chesspiece piece) {
    //colocar nova peça no tabuleiro
    board.placePiece(piece, new ChessPosition(column, row).toPosition());
}


  private void initialSetup() {
    //colocar as peças no tabuleiro

        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new king(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new king(board, Color.BLACK));
  }

}