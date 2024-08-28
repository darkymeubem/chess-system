package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;

public class Pawn  extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }
}
