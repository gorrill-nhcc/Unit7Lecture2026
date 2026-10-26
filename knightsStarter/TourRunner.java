package knightsStarter;

import java.util.ArrayList;

/**
 * Tour runner handles the tour strategy.
 * This tour runner will pick random moves and run tour.
 * The class will initialize the starting locaiton for the knight
 * There is one method to runBasicTour(TourLogicService service)
 * This will continue to make moves as long as moves are available.
 * Each Tour strategy will be implimented in a separate class.
 */
public class TourRunner {
    private int moveCounter = 1;
    private int startRow, startCol;

    public TourRunner(int row, int col){
        startRow = row;
        startCol = col;
    }

    public boolean runBasicTour(TourLogicService service){
        // below is required to put the knight on the board in the first location
        boolean running = service.startTour(moveCounter, startRow, startCol);
        while (running) {
            moveCounter++;// update the moveCounter first as a move is made before the loop
            ArrayList<Integer> moves = service.getAvailableMoves();
            boolean moveMade = false;
            if(moves.size() > 0){
                //int randMove = (int)(Math.random() * moves.size());
            
                moveMade = service.tryMove(service.pickBestAvailableMove(), moveCounter);
            }
                //i forgot to update the position of the knight!
            running = moveMade && moveCounter < 64;
        }
    
        return running;
    }

    public int getMoveCounter(){
        return moveCounter;
    }
}
