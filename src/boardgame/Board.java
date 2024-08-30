package src.boardgame;

import src.Chess.ChessMatch;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns <1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 columns");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int colum) {
        if(!positionExists(row,colum)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][colum];
    }

    public Piece piece(Position position) {
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColum()];
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position: " + position);
        }
        pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int colum) {
        return row >= 0 && row < rows && colum >= 0 && colum < columns;


    }

    public boolean positionExists(Position position) {

        //#JEITO 1- DE FAZER
//        if(position.getRow() > 8 && position.getRow() < 0 && position.getRow() < rows)  {
//            return false;
//        }if(position.getColum() > 8 && position.getColum() < 0 && position.getColum() < columns){
//            return false;
//        }
//        return true;

        return positionExists(position.getRow(), position.getColum());
    }



    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColum()] = null;
        return aux;
    }

    public int getRows() {
        return rows;
    }



    public int getColumns() {
        return columns;
    }


}
