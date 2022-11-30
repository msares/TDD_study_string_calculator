import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SPLIT_REGEX = "[,:]";
    private static final String CUSTOM_DELIMETER_REGEX = "//(.)\n(.*)";
    private static final String NUM_REGEX = "^[0-9]*$";
    private static final String ERR_MSG_MINUS = "숫자 이외의 값 또는 음수값은 잘못된 입력값입니다.";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMETER_REGEX);
    private static final Pattern SPLIT_PATTERN = Pattern.compile(SPLIT_REGEX);
    private static final int CUSTOM_DELIMITER_EXTRACT = 1;
    private static final int CUSTOM_PLAIN_STRING_EXTRACT = 2;


    public static int splitAndSum(String inputPlainString) {
        if (isThatNull(inputPlainString)) {
            return 0;
        }
        String[] splitArr = splitWorking(inputPlainString);
        return sumCalculator(splitArr);
    }

    private static boolean isThatNull(String inputPlainString) {
        return inputPlainString == null || inputPlainString.isEmpty();
    }


    private static String[] splitWorking(String inputPlainString) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputPlainString);
        if (matcher.find()) {
            Pattern customPattern = Pattern.compile(matcher.group(CUSTOM_DELIMITER_EXTRACT));
            return customPattern.split(matcher.group(CUSTOM_PLAIN_STRING_EXTRACT), 0);
        }
        return SPLIT_PATTERN.split(inputPlainString, 0);
    }

    private static int sumCalculator(String[] splitArr) {
        int resultSum = 0;
        for (String s : splitArr) {
            resultSum += checkNumRange(s);
        }
        return resultSum;
    }

    private static int checkNumRange(String strSplitArrElement) {
        boolean isThatNum = Pattern.matches(NUM_REGEX, strSplitArrElement);
        if (!isThatNum) {
            throw new IllegalArgumentException(ERR_MSG_MINUS);
        }
        return Integer.parseInt(strSplitArrElement);
    }
}


