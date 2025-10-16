package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static String userInputValue = ""; //유저 입력 변수

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        userInput();
    }

    /**
     * 문자열 받는 기능
     */
    public static void userInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userInputValue = readLine();
        System.out.println("입력받은 값 : " + userInputValue);
    }

}
