package racingcarGame;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    private RoundNumber roundNumber;
    private Cars cars;
    RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

    private void start() throws Exception {
        InputView inputView = new InputView();

        CarNamesString carNamesString = inputView.getInputForCarNames();
        StringSeparator stringSeparator = new StringSeparator(",");
        List<String> carNames = stringSeparator.separate(carNamesString.getString());
        cars = new Cars(carNames);

        roundNumber = inputView.getInputForFinalRoundNumber();
    }

    private void play() {
        ResultView resultView = new ResultView();

        while(!roundNumber.isFinalRound()) {
            cars.moveCars(randomNumbersGenerator.generateNumbers(cars.getSize()));
            resultView.printResultOfRound(roundNumber.isFirstRound(), cars.getAllCarsData());
            roundNumber.upRoundNumber();
        }

        resultView.printWinners(cars.getWinners());
    }

    public static void main(String[] args) throws Exception {
        PlayGame playGame = new PlayGame();
        try {
            playGame.start();
            playGame.play();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("게임을 종료합니다.");
    }
}
