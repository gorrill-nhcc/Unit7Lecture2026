package knightsStarter;

/**
 * BoardModel is the domain class.
 * it has the 2d int array - board
 * two constants to track the number of rows and columns
 * it performs the following functions:
 * placing a piece on the board
 * validating a cell
 * checking if a cell has been visited
 * providing access to the board through a getter
 * printing the state of the board
 * resetting the state of the board
 * 
 * there is no business logic in this.
 * All of the decisions for running a tour are made in the Logic Service
 * All of the automation for running a tour and evaluating a tour after
 * completion are in
 * the various Runner classes.
 */

import java.util.Arrays;

public class BoardModel {
    private final int NUM_ROWS = 8;
    private final int NUM_COLS = 8;

    private int[][] board;

    public BoardModel(){
        board = new int[NUM_ROWS][NUM_COLS];
    }

    public void placePiece(int marker, int row, int col){
        board[row][col] = marker;
    }

    public boolean validCell(int row, int col) {
        boolean validRow = row >= 0 && row < board.length;
        boolean validCol = validRow && col >= 0 && col < board[row].length;
        return validRow && validCol;
    }

    public boolean cellVisited(int row, int col){
        return board[row][col] > 0;
    }

    public int[][] getBoard(){
        return board;
    }

    public void printBoard(){
        for(int [] row : board){
            System.out.println(Arrays.toString(row)); // fixed bug
        }
    }

    public void resetBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = 0;
            }
        }
    }
}
