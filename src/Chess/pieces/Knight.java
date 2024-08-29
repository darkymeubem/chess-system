package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }
    public String toString() {
        return "Kn";
    }
}
