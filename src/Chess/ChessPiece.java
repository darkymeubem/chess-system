package src.Chess;

import src.boardgame.Board;
import src.boardgame.Piece;
import src.boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    protected boolean isThereOpponentPiece(Position position){
        ChessPiece aux = (ChessPiece) getBoard().piece(position);

       return aux != null && aux.getColor() != color;
    }
    public Color getColor() {
        return color;
    }
}
