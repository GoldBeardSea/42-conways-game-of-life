package com.gbbeard.conwaysgame;

import android.graphics.Color;

public class Cell {
// This code largerly comes from a reference of DZ zone
        public float xx;
        public float yy;
        public boolean alive;
        public int color;

        public Cell(float xx, float yy, boolean alive, int color){
            this.xx = xx;
            this.yy = yy;
            this.alive = alive;
            this.color = color;

        }

        public void reborn (){

            alive = true;
            color = Color.BLACK;
        }

        public void die(){

            alive = false;
            color = Color.WHITE;
        }

        public void transform(){
            alive = !alive;
        }

        public static Cell get(int row, int col){
            return CellEngine.cellGrid[row][col];
        }

        private static boolean getCellValue(boolean[][] gameGrid, int row, int col) {
            if (row < 0 || col < 0 || row >= gameGrid.length || col >= gameGrid[row].length) {
                return false;
            }
            return gameGrid[row][col];
        }

    }
}
