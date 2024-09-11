package src.teste;

import src.Chess.ChessException;
import src.Chess.ChessMatch;
import src.Chess.ChessPiece;
import src.Chess.ChessPosition;
import src.boardgame.Position;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> captured  = new ArrayList<>();

        while (true) {
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


            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }

    }
}
