package knightsStarter;

import java.util.ArrayList;

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

    public TourLogicService(BoardModel board) {
        this.board = board;
    }

    final int ROW_MOVES[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
    final int COL_MOVES[] = { 1, -1, 1, -1, 2, -2, 2, -2 };
    // (4,4) move - 3 ==> (4 + -2, 4 + -1) ==> (2, 3)

    // if the [row, col] is a valid cell, place the marker and return true
    public boolean startTour(int marker, int row, int col) {

        return false;
    }

    // makeKnightMove() if moveIndex results in a valid cell on the board
    public boolean tryMove(int moveIndex, int marker) {

        return false;
    }

    public int calcRowMove(int moveIndex) {
        return -1;
    }

    public int calcColMove(int moveIndex) {
        return -1;
    }

    // Pick first move from available moves? A random move? Develop a heuristic?
    public int pickBestAvailableMove() {

        return -1;
    }

    // return a list of all available move numbers on the board.
    public ArrayList<Integer> getAvailableMoves() {
        // instantiate the list
        ArrayList<Integer> moves = new ArrayList<>();

        return moves;
    }

    private void makeKnightMove(int marker, int row, int col) {

    }
}
