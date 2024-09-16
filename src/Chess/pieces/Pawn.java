package src.Chess.pieces;

import src.Chess.ChessMatch;
import src.Chess.ChessPiece;
import src.Chess.Color;
import src.boardgame.Board;
import src.boardgame.Position;

public class Pawn  extends ChessPiece {
    private ChessMatch chessMatch;
    public Pawn(Board board, Color color,ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            //#specialmove - enPassant (White)
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(),position.getColum() -1 );
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()){
                    mat[left.getRow() -1][left.getColum()] = true;
                };

                Position right = new Position(position.getRow(),position.getColum() +1 );
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()){
                    mat[right.getRow() -1][right.getColum()] = true;
                };
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

            //#specialmove - enPassant (Black)
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(),position.getColum() - 1 );
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()){
                    mat[left.getRow() +1][left.getColum()] = true;
                };

                Position right = new Position(position.getRow(),position.getColum() +1 );
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()){
                    mat[right.getRow() +1][right.getColum()] = true;
                };
            }


        }




        return mat;
    }
}
