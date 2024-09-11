package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;
import src.boardgame.Position;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        //above
        p.setValues(position.getRow() -1 ,position.getColum());
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //below
        p.setValues(position.getRow() +1 ,position.getColum());
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //left
        p.setValues(position.getRow()  ,position.getColum() -1 );
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //right
        p.setValues(position.getRow() ,position.getColum() +1);
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //nw
        p.setValues(position.getRow() -1,position.getColum() -1);
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //ne
        p.setValues(position.getRow() -1,position.getColum() +1);
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //sw
        p.setValues(position.getRow() +1,position.getColum() -1);
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }

        //se
        p.setValues(position.getRow() +1,position.getColum() +1);
        if(getBoard().positionExists(p) && canMove(p)){

            mat[p.getRow()][p.getColum()] = true;
        }


        return mat;
    }
}
