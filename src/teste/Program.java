package src.teste;

import src.Chess.ChessException;
import src.Chess.ChessMatch;
import src.Chess.ChessPiece;
import src.Chess.ChessPosition;
import src.boardgame.Position;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> captured  = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {
                UI.printMatch(chessMatch,captured);
                System.out.println();
                System.out.println("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.printBoard(chessMatch.getPieces(),possibleMoves);


                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
                if(chessMatch.getPromoted() != null){
                    System.out.println("Enter piece for promotion: (B/Q/N/R)");
                    String type = sc.nextLine();
                    while(!type.equals("B") && !type.equals("N") &&!type.equals("R") && !type.equals("Q")){
                        System.out.println("Invalid value! Enter piece for promotion: (B/Q/N/R)");
                        type = sc.nextLine();
                    }
                    chessMatch.replacePromotedPiece(type);
                }


            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
        UI.printMatch(chessMatch,captured);

    }
}
