package knightsStarter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TourLogicService: The "Engine" of the Knight's Tour simulation.
 * This class serves as the Service layer between the BoardModel (Data)
 * and the Runner (Execution). Its primary responsibility is to maintain the
 * Knight's current position and enforce the specific movement rules of the
 * game.
 * 
 * ARCHITECTURAL ROLES:
 * 1. State Owner: It encapsulates the Knight's coordinates, ensuring that the
 * internal row/column state only updates when a legal move is committed to the
 * Board.
 * 2. Rule Enforcer: It validates potential moves against both the board's
 * physical boundaries and the "already visited" game rule.
 * 3. Abstraction Layer: It allows Runners to focus on tour strategy (e.g.,
 * random selection, Warnsdorff’s Rule) without needing to know array index
 * math.
 * 
 * INTERACTIONS:
 * - BoardModel: The Service reads/writes to the board to verify and record
 * progress.
 * - Runner: The Runner triggers the Service to attempt moves. The Runner
 * decides "which" move to try; the Service determines "if" that move can
 * happen.
 * 
 * EXTENSIBILITY:
 * This service is strategy-agnostic. While currently used by a BasicTourRunner
 * for random movement, it can support more advanced 'Agent' strategies (like
 * Heuristic or Backtracking search) by utilizing the getAvailableMoves() method
 * to
 * "look ahead" at the board state.
 */
public class TourLogicService {
    BoardModel board;
    private int rowPosition;
    private int colPosition;

    /**
     * for(int i = 0; i < accessModel.length; i++){
        * for(int j = 0; j < accessModel[i].length; j++){
        * accessVals[i][j] = ACESS_MODEL[i][j];
        * }
     * }
     */
    // this is constant and is used to initialize and reset the living access array
    private final int[][] ACCESSIBILITY_MODEL = {
            { 2, 3, 4, 4, 4, 4, 3, 2 },
            { 3, 4, 6, 6, 6, 6, 4, 3 },
            { 4, 6, 8, 8, 8, 8, 6, 4 },
            { 4, 6, 8, 8, 8, 8, 6, 4 },
            { 4, 6, 8, 8, 8, 8, 6, 4 },
            { 4, 6, 8, 8, 8, 8, 6, 4 },
            { 3, 4, 6, 6, 6, 6, 4, 3 },
            { 2, 3, 4, 4, 4, 4, 3, 2 }
    };

    // this is the living accessibility array
    private int[][] accessVals; // initially null, need to instantiate

    public TourLogicService(BoardModel board) {
        this.board = board;
        accessVals = new int[ACCESSIBILITY_MODEL.length][ACCESSIBILITY_MODEL[0].length];
        updateAccessVals(ACCESSIBILITY_MODEL);
        printAccessVals();
    }

    
    final int ROW_MOVES[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
    final int COL_MOVES[] = { 1, -1, 1, -1, 2, -2, 2, -2 };
    // (4,4) move - 3 ==> (4 + -2, 4 + -1) ==> (2, 3)
    // move selected => 3
    // int moveNum = 3;
    // rowPosition = rowPosition + ROW_MOVES[moveNum];
    // colPosiiton = colPosition + COL_MOVES[moveNum];

    // if the [row, col] is a valid cell, place the marker and return true
    public boolean startTour(int marker, int row, int col) {
        if(board.validCell(row, col) && !board.cellVisited(row, col)){
            board.placePiece(marker, row, col);
            rowPosition = row;
            colPosition = col;
            return true;
        }
        return false;
    }

    // makeKnightMove() if moveIndex results in a valid cell on the board
    public boolean tryMove(int moveIndex, int marker) {
        int proposedRow = calcRowMove(moveIndex); // bug here
        int proposedCol = calcColMove(moveIndex);
        if(board.validCell(proposedRow, proposedCol) && 
        !board.cellVisited(proposedRow, proposedCol)){
            makeKnightMove(marker, proposedRow, proposedCol);
            rowPosition = proposedRow;
            colPosition = proposedCol;
            return true;
        }
        return false;
    }

    // int moveNum = 3;
    // rowPosition = rowPosition + ROW_MOVES[moveNum];
    // colPosiiton = colPosition + COL_MOVES[moveNum];
    public int calcRowMove(int moveIndex) {
        return rowPosition + ROW_MOVES[moveIndex];
    }

    public int calcColMove(int moveIndex) {
        return colPosition + COL_MOVES[moveIndex];
    }

    // Pick first move from available moves? A random move? Develop a heuristic?
    public int pickBestAvailableMove() {
        // this will get fixed!
        ArrayList<Integer> moves = getAvailableMoves();
        int lowAccess = 9;
        int bestMove = -1;

        // [2, 5, 6, 7]
        for(int i = 0; i < moves.size(); i++){
            int proposedRow = calcRowMove(moves.get(i));
            int proposedCol = calcColMove(moves.get(i));
            int currentAccess = accessVals[proposedRow][proposedCol];
            if(currentAccess < lowAccess){
                lowAccess = currentAccess;
                bestMove = moves.get(i);
            }
        }
        
        return bestMove;
    }

    // return a list of all available move numbers on the board.
    public ArrayList<Integer> getAvailableMoves() {
        // instantiate the list
        ArrayList<Integer> moves = new ArrayList<>();
        for(int i = 0; i < ROW_MOVES.length; i++){
            int proposedRow = calcRowMove(i); // bug here
            int proposedCol = calcColMove(i);
            boolean validCell = board.validCell(proposedRow, proposedCol) 
            && !board.cellVisited(proposedRow, proposedCol);
            if(validCell){
                moves.add(i);
            }
        }
        return moves;
    }

    private void makeKnightMove(int marker, int row, int col) {
        board.placePiece(marker, row, col);
    }

    private void updateAccessVals(int[][] accessModel){
        for(int i = 0; i < accessModel.length; i++){
            for(int j = 0; j < accessModel[i].length; j++){
                accessVals[i][j] = accessModel[i][j];
                // accessVals[i][j] = ACCESSIBILITY_MODEL[i][j];
            }
        }
    }

    public void printAccessVals(){
        for(int[] row: accessVals){
            System.out.println(Arrays.toString(row));
        }
    }
}
