package src.Chess.pieces;

import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;
import src.boardgame.Position;

public class Pawn  extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        //first chess move
        if(getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1, position.getColum());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColum()] = true;

            }
            if(getMoveCount() == 0){
                p.setValues(position.getRow() - 2, position.getColum());
                Position p2 = new Position(position.getRow() - 1, position.getColum());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                    mat[p.getRow()][p.getColum()] = true;

                }
            }

            p.setValues(position.getRow() - 1, position.getColum() -1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p) ){
                mat[p.getRow()][p.getColum()] = true;

            }

            p.setValues(position.getRow() - 1, position.getColum() +1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p) ){
                mat[p.getRow()][p.getColum()] = true;

            }
        }


        else{
            p.setValues(position.getRow() + 1, position.getColum());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColum()] = true;

            }
            if(getMoveCount() == 0){
                p.setValues(position.getRow() + 2, position.getColum());
                Position p2 = new Position(position.getRow() + 1, position.getColum());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                    mat[p.getRow()][p.getColum()] = true;

                }
            }

            p.setValues(position.getRow() + 1, position.getColum() +1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p) ){
                mat[p.getRow()][p.getColum()] = true;

            }

            p.setValues(position.getRow() + 1, position.getColum() -1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p) ){
                mat[p.getRow()][p.getColum()] = true;

            }
        }




        return mat;
    }
}
