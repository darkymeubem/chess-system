package src.boardgame;

public class Position {
    private int row;
    private int colum;

    public Position(int row, int colum) {
        this.row = row;
        this.colum = colum;
    }

    public void setValues(int row, int column){
        this.row = row;
        colum = column;
    }

    public int getRow() {
        return row;
    }

    public int getColum() {
        return colum;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    @Override
    public String toString() {
        return row + ", " + colum;
    }
}
