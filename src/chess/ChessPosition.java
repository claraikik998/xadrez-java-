package chess;

import boardgame.Position;

public class ChessPosition {
    
    private char column;
    private int row;


    public ChessPosition(char column, int row) {
        //crio um caracter defensivo para garantir que os valores de linha sejam opçoes existentes
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Erro!! Valores válidos são de a1 até h8.");
        }
        this.column = column;
        this.row = row;
    }


    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
 //matriz_row = 8 - chess_row
 //matriz_column = chess_column - 'a'
protected Position toPosition() {
    return new Position(8 - row, column - 'a');
}  

 protected static ChessPosition fromPosition(Position position) {
    return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());

 }
 @Override
 public String toString() {
     return "" + column + row;
     // '' para concatenar o char com o int e imprimir na tela
 }



}
