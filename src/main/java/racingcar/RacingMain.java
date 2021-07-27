package racingcar;

import java.util.LinkedHashMap;

public class RacingMain {
    private static RacingGame racingGame;

    public void run() throws Exception {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        racingGame = new RacingGame(inputView.getNameString(), inputView.getRoundNumber());
        outputView.printStartMessage();
        while(!racingGame.end()) {
            RandomMovingActions randomMovingActions = new RandomMovingActions(racingGame.getSizeOfCars());
            LinkedHashMap<String, Integer> roundResult = racingGame.playOneRound(randomMovingActions.getMovingActions());
            outputView.printRoundResult(roundResult);
        }

        outputView.printWinners(racingGame.getResult());
    }

    public static void main(String[] args) throws Exception {
        while(true){
            try {
                RacingMain racingMain = new RacingMain();
                racingMain.run();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}
