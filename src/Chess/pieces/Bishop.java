package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;
import src.boardgame.Piece;
import src.boardgame.Position;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //nw
        p.setValues(position.getRow() -1,position.getColum() -1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() - 1);
            p.setColum(p.getColum() -1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //ne
        p.setValues(position.getRow() -1,position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() - 1);
            p.setColum(p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //sw
        p.setValues(position.getRow() +1,position.getColum() -1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() + 1);
            p.setColum(p.getColum() -1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }


        //se
        p.setValues(position.getRow() +1,position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() + 1);
            p.setColum(p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }


        return mat;
    }
}
