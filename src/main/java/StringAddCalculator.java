import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_SEP_RULES = "//(.)\n(.*)";
    private static final String DEFAULT_SEP_RULES = ",|:";
    private static final String NEGATIVE_NUM_RULES = "^-[0-9.]";

    public static int splitAndSum(String inputString) {
        if (isEmptyString(inputString)) {
            return 0;
        }
        if (isSingleNumber(inputString)) {
            return Integer.parseInt(inputString);
        }
        return calculate(getStringArray(inputString));
    }

    private static boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isSingleNumber(String input) {
        return input.length() == 1;
    }


    private static String[] getStringArray(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEP_RULES).matcher(input);
        if (matcher.find()) {
            return splitString(matcher.group(1), matcher.group(2));
        }
        return splitString(DEFAULT_SEP_RULES, input);
    }

    private static String[] splitString(String delimiter, String targetString) {
        isNumberNegative(targetString);
        return targetString.split(delimiter);
    }


    private static void isNumberNegative(String targetString) {
        Matcher matcher = Pattern.compile(NEGATIVE_NUM_RULES).matcher(targetString);
        if (matcher.find()) {
            throw new RuntimeException();
        }
    }

    private static int calculate(String[] inputNumbers) {
        int result = 0;
        for (String inputNumber : inputNumbers) {
            result += Integer.parseInt(inputNumber);
        }
        return result;
    }
}
