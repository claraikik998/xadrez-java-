package application;

import java.util.Scanner;
import chess.ChessMatch;
import chess.chesspiece;
import chess.ChessException;
import java.util.InputMismatchException;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
       //funçao para mostrar o tabuleiro

        while (true) {
          try{
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces()); //imprime o tabuleiro
            System.out.println();//quebra de linha
            System.out.print("Source: ");       
            chess.ChessPosition source = UI.readChessPosition(sc);

            boolean[][] possibleMoves = chessMatch.possibleMoves(source);
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces(), possibleMoves); //imprime o tabuleiro
            //vai mostrar colorido pro usuario as posições

            System.out.println();
            System.out.print("Target: ");
            chess.ChessPosition target = UI.readChessPosition(sc);
    
            chesspiece capturedPiece = chessMatch.performChessMove(source, target);
          }
           catch (ChessException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
           }
            catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
            }

        }
    }
}
