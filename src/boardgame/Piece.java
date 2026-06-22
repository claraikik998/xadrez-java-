package boardgame;

public  abstract class Piece {
    //posição que não sera vista no tabuleiro
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; 
    }
//somente a classes dentro do mesmo pacote poderam acessar o tabuleiro
    protected Board getBoard() {
        return board;
    }
  
 public abstract boolean[][] possibleMoves();
 public boolean possibleMove(Position position) {
    return possibleMoves()[position.getRow()][position.getColumn()];
 }

 public boolean isThereAnyPossibleMove() {
    boolean[][] mat = possibleMoves();
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat.length; j++) { //supondo quue a matriz é quadrada
            if (mat[i][j]) {
                return true;
            }
        }
    }
    return false;
 }

}
