package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static String userInputValue = ""; //유저 입력 변수
    static String[] textSeparator = new String[]{",|", ":|", ""};//구분자
    static String[] userInputValueTextSeparator;//구분자로 나눠진 유저입력값

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        userInput();
        customTextSeparator();
        userInputValueTextSeparator = getTextSplit();
        checkValue();
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
            userInputValue = userInputValue.substring(userInputValue.indexOf("\\n") + 2);
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

    /**
     * 문자열을 구분자로 나누는 기능
     */
    public static String[] getTextSplit() {
        return userInputValue.split(textSeparator[0] + textSeparator[1] + textSeparator[2]);
    }

    /**
     * 구분자로 나눠진 값  밸리데이션 기능
     */
    public static void checkValue() {
        for (int i = 0; i < userInputValueTextSeparator.length; i++) {
            checkString(userInputValueTextSeparator[i].trim(), i);
        }
    }

    /**
     * 문자체크
     */
    public static void checkString(String val, int i) {
        try {
            if (changeTrim(val, i)) {
                int parseIntVal = Integer.parseInt(val);
                checkNegative(parseIntVal);
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 빈문자 0으로 치환
     */
    public static boolean changeTrim(String val, int i) {
        if (val.equals("")) {
            userInputValueTextSeparator[i] = "0";
            return false;
        }
        return true;
    }

    /**
     * 음수체크
     */
    public static void checkNegative(int val) {
        if (val < 0) {
            throw new IllegalArgumentException();
        }
    }


}
