package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;
import src.boardgame.Position;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        p.setValues(position.getRow() - 1, position.getColum());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColum());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
