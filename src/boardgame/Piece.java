package boardgame;

public class Piece {
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

}
