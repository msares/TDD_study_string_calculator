import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int EXTRACT_DELIMITER_PARAM = 1;
    private static final int EXTRACT_TARGET_STRING_PARAM = 2;
    private static final String NEGATIVE_NUM_ERROR = "Negative numbers are not allowed.";
    private static final String INVALID_TOKEN_ERROR = "You can only use numbers, not strings.";

    private static final String DEFAULT_SEP_STRING = ",|:";
    private static final String CUSTOM_SEP_STRING = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEP_RULES = Pattern.compile(CUSTOM_SEP_STRING);


    public static int splitAndSum(String inputString) {
        if (isEmptyString(inputString)) {
            return 0;
        }
        if (isSingleNumber(inputString)) {
            return Integer.parseInt(inputString);
        }
        System.out.println(calculate(splitString(inputString)));
        return calculate(splitString(inputString));
    }

    private static boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isSingleNumber(String input) {
        return input.length() == 1;
    }

    private static String[] splitString(String input) {
        Matcher matcher = CUSTOM_SEP_RULES.matcher(input);
        if (matcher.find()) {
            return matcher.group(EXTRACT_TARGET_STRING_PARAM).split(matcher.group(EXTRACT_DELIMITER_PARAM));
        }
        return input.split(DEFAULT_SEP_STRING);
    }

    //숫자가 아닌 문자 입력 시 예외처리
    private static int getInteger(String input) {
        int returnValue;
        try {
            returnValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(INVALID_TOKEN_ERROR, e);
        }
        if (checkNegativeNumbers(returnValue)) {
            throw new RuntimeException(NEGATIVE_NUM_ERROR, new IllegalArgumentException());
        }

        return returnValue;
    }

    private static boolean checkNegativeNumbers(int input) {
        return input < 0;
    }

    private static int calculate(String[] inputNumbers) {
        int result = 0;
        for (String inputNumber : inputNumbers) {
            result += getInteger(inputNumber);
        }
        return result;
    }
}
