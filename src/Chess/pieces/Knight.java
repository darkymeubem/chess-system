package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;
import src.boardgame.Position;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    public String toString() {
        return "N";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);


        // above right
        p.setValues(position.getRow() - 2, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow() - 1, position.getColum() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }



        // above left
        p.setValues(position.getRow() - 2, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow() - 1, position.getColum() - 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }



        // below right
        p.setValues(position.getRow() + 2, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow() + 1, position.getColum() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }



        // below left
        p.setValues(position.getRow() + 2, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }

        p.setValues(position.getRow() - 1, position.getColum() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;

        }


        return mat;
    }
}
