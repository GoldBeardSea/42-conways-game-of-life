package com.gbbeard.conwaysgame;

class CellEngine {

    public CellEngine(){}
    public static Cell[][] cellGrid;
    public boolean getCell(boolean[][] cells, int row, int col) {
        if (row < 0 || col < 0 || row >= cells.length || col >= cells[row].length) {
            return false;
        }
        return cells[row][col];
    }

    public int checkCells(boolean[][] cellGrid, int row, int col) {
        int count = 0;
        boolean hasCell = getCell(cellGrid,row,col + 1);
        if (hasCell) {
            count++;
        }
        hasCell = getCell(cellGrid,row + 1, col + 1);
        if (hasCell) {
            count++;
        }
        hasCell = getCell(cellGrid,row + 1, col);
        if (hasCell) {
            count++;
        }
        hasCell= getCell(cellGrid,row+1, col-1);
        if (hasCell) {
            count++;
        }
        hasCell = getCell(cellGrid,row, col-1);
        if(hasCell){
            count++;
        }
        hasCell = getCell(cellGrid,row-1,col-1);
        if(hasCell){
            count++;
        }
        hasCell = getCell(cellGrid,row-1,col);
        if(hasCell){
            count++;
        }
        hasCell = getCell(cellGrid,row-1,col+1);
        if(hasCell){
            count++;
        }

        return count;
    }

}
