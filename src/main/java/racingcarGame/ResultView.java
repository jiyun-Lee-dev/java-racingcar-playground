package racingcarGame;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ResultView {
    public void printResultOfRound(boolean isFirstRound, LinkedHashMap<String, Integer> result) {
        System.out.println("");
        if (isFirstRound) {
            System.out.println("실행 결과");
        }
        Set<String> keys = result.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + getDistMark(result.get(key)));
        }
    }

    private String getDistMark(int dist) {
        String mark = "";
        for(int i = 0; i < dist; i++) {
            mark += "-";
        }
        return mark;
    }

    public void printWinners(List<String> winners) {
        System.out.println("");
        String message = "";
        for (String winner : winners) {
            message += winner;
            message += ",";
        }
        System.out.println(message.substring(0, message.length() - 1) + "가 최종 우승했습니다.");
    }
}
