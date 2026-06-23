package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class chesspiece extends Piece{
    
    private Color color;
    private int moveCount; // Adicionado para contar os movimentos das peças

    public chesspiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
//
    public Color getColor() {
        return color;
    }

    public int getMoveCount() { // Adicionado
        return moveCount;
    }
    
    protected void increaseMoveCount() { // Adicionado
        moveCount++;
    }

    protected void decreaseMoveCount() { // Adicionado
        moveCount--;
    }

    public ChessPosition getChessPosition() { // Adicionado
        return ChessPosition.fromPosition(position);
    }

   protected boolean isThereOpponentPiece(Position position) {
        chesspiece p = (chesspiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
    
}