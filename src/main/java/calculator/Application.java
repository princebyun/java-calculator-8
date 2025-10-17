package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static String userInputValue = ""; //유저 입력 변수
    static String[] textSeparator = new String[]{",", ":", ""};

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        userInput();
        customTextSeparator();

    }

    /**
     * 문자열 받는 기능
     */
    public static void userInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userInputValue = readLine();
    }

    /**
     * 구분자를 커스텀 생성 기능
     */
    public static void customTextSeparator() {
        if (checkCustomTextSeparator()) {
            String ctSeparator = userInputValue.substring(userInputValue.indexOf("//") + 2,
                    userInputValue.indexOf("\\n"));
            textSeparator[2] = ctSeparator;
        }
    }

    /**
     * 커스텀 구분자가 있는지 확인하는 기능
     */
    public static boolean checkCustomTextSeparator() {
        boolean valueFlag1 = userInputValue.contains("//");
        boolean valueFlag2 = userInputValue.contains("\\n");
        if (valueFlag1 && valueFlag2) {
            return true;
        }
        return false;
    }


}
