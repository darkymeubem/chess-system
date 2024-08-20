package src.teste;

import src.Chess.ChessMatch;
import src.boardgame.Position;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
