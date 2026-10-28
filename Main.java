import knightsStarter.*;
public class Main {
    public static void main(String[] args) {
        BoardModel model = new BoardModel();
        TourLogicService brains = new TourLogicService(model);
        TourRunner manager = new TourRunner(4, 4);
        manager.runBasicTour(brains);
        model.printBoard();
        brains.printAccessVals();
    }
}
