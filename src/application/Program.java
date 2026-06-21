package application;


import chess.ChessMatch;

public class Program {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
       //funçao para mostrar o tabuleiro
        UI.printBoard(chessMatch.getPieces());
    }
}
