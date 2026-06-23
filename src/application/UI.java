package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import chess.Color;
import chess.chesspiece; 
import chess.ChessPosition;
import chess.ChessMatch;

public class UI {
    
// retirado de https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";
public static final String ANSI_PINK = "\u001B[38;5;205m";  // cor rosa

public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
public static final String ANSI_PINK_BACKGROUND = "\u001B[48;5;205m"; // cor rosa de fundo

//tirado do arquivo do projeto
// https://stackoverflow.com/questions/2979383/java-clear-the-console
public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
} 

public static ChessPosition readChessPosition(Scanner sc) {
   try{
        String s = sc.nextLine();
        char column = s.charAt(0);
        int row = Integer.parseInt(s.substring(1));
        return new ChessPosition(column, row);
    }
    catch (RuntimeException e) {
        throw new InputMismatchException("Erro!! Valores válidos são de a1 até h8.");
        //uma exeção que ja tem no java
    }
}
    public static void printBoard(chesspiece[][] pieces) {
        // parte do desenho do tabuleiro

        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " "); // imprime 8-
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false); //imrprime 8---------
            }
            System.out.println(); // pula ---S
        } 
        System.out.println("  a b c d e f g h");
    } 
   
    public static void printBoard(chesspiece[][] pieces, boolean [][] possibleMoves) {
            // parte do desenho do tabuleiro

            for (int i = 0; i < pieces.length; i++) {
                System.out.print((8 - i) + " "); // imprime 8-
                for (int j = 0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j] ); //imrprime 8---------
                }
                System.out.println(); // pula ---S
            } 
            System.out.println("  a b c d e f g h");
        } 

    public static void printMatch(ChessMatch chessMatch, List<chesspiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(captured);
        System.out.println();
        System.out.println("Turno: " + chessMatch.getTurn());
        if (!chessMatch.getCheckMate()) {
            System.out.println("Aguardando jogador: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("XEQUE!");
            }
        } else {
            System.out.println("XEQUE-MATE!");
            System.out.println("Vencedor: " + chessMatch.getCurrentPlayer());
        }
    }

   private static void printPiece(chesspiece piece, boolean background) { // ou ChessPiece dependendo de como você escreveu
        if(background){
            System.out.print(ANSI_PINK_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET); //  Adicionado o ANSI_RESET aqui para limpar o fundo rosa nos espaços vazios
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                // Troquei ANSI_BLACK por ANSI_PINK para as peças ficarem rosas já que o terminal é preto
                System.out.print(ANSI_PINK + piece + ANSI_RESET); 
            }
        }
        System.out.print(" ");
    }

    private static void printCapturedPieces(List<chesspiece> captured) {
        List<chesspiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).toList();
        List<chesspiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).toList();
        System.out.println("Peças capturadas:");
        System.out.print("Brancas: " + ANSI_WHITE);
        System.out.print(white);
        System.out.println(ANSI_RESET);
        System.out.print("Rosas: " + ANSI_PINK);
        System.out.print(black);
        System.out.println(ANSI_RESET);
    }
}