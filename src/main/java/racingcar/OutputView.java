package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class OutputView {
    public void printStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(LinkedHashMap<String, Integer> result) {
        Set<String> keys = result.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + printDash(result.get(key)));
        }
        System.out.println();
    }

    private String printDash(int position) {
        StringBuilder dash = new StringBuilder();
        for(int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }

    public void printWinners(List<String> winners) {
        System.out.println();
        StringBuilder message = new StringBuilder();
        for (String winner : winners) {
            message.append(winner);
            message.append(",");
        }
        System.out.println(message.substring(0, message.length() - 1) + "가 최종 우승했습니다.");
    }
}
