package com.company;

public class Grid {
    private int rows, columns;
    private boolean onTable=true;



    public Grid() {
    }

    public void setGrid(int x, int y) {
        setColumns(y);
        setRows(x);
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean isOnTable() {
        return onTable;
    }

    public void printGridDimension() {
        System.out.println("this grid has rows = " + rows + " and columns = " + columns);
    }

    public boolean isValid(int x, int y) {

            if (x >= 0 && y >= 0 && x < this.rows  && y < this.columns ) {
                return true;
            }
            onTable=false;
            return false;
    }
}
