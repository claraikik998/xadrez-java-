package application;

import chess.chesspiece; // O VS Code deve colocar esse import automaticamente

public class UI {
    
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

    private static void printPiece(chesspiece piece) {
        // imprimir uma unica peça
        if (piece == null) {
            System.out.print("-");
        } else {
            System.out.print(piece);
        }
        System.out.print(" "); 
    }
}
