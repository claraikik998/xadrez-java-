package application;

import java.util.Scanner;
import chess.ChessMatch;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
       //funçao para mostrar o tabuleiro

        while (true) {
         UI.printBoard(chessMatch.getPieces()); //imprime o tabuleiro
            System.out.println();//quebra de linha
            System.out.print("Source: ");       
            chess.ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            chess.ChessPosition target = UI.readChessPosition(sc);
    
            chessMatch.performChessMove(source, target);

        }
    }
}
