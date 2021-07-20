package racingcarGame;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String getInputForCarNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        CarNamesString carNamesString = new CarNamesString(scanner.nextLine());
        return carNamesString.getString();
    }

    public Integer getInputForFinalRoundNumber() throws Exception {
        System.out.println("시도할 횟수는 몇회인가요?");
        FinalRoundNumber finalRoundNumber = new FinalRoundNumber(scanner.nextInt());
        return finalRoundNumber.getInt();
    }
}