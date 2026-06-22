package application;

import chess.Color;
import chess.chesspiece; 

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

    public static void printBoard(chesspiece[][] pieces) {
        // parte do desenho do tabuleiro

        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " "); // imprime 8-
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]); //imrprime 8---------
            }
            System.out.println(); // pula ---S
        } 
        System.out.println("  a b c d e f g h");
    } 

    private static void printPiece(chesspiece piece) { // ou ChessPiece dependendo de como você escreveu
        if (piece == null) {
            System.out.print("-");
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


}
