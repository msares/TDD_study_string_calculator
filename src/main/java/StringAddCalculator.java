
/*
 * final 상수 적극 활용하기!
 *
 * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
 * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
 * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
 * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
 * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
 * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static String[] strSplitArr;
    static String SPLIT_REGEX = "[,:]";
    static final String CUSTOM_DELIMETER_REGEX = "//(.)\n(.*)";
    static final String NUM_REGEX = "^[0-9]*$";
    static final String ERR_MSG_MINUS = "숫자 이외의 값 또는 음수값은 계산이 불가능합니다.";
    static Matcher matcher;

    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        splitCal(str);
        return sumCal(strSplitArr);
    }

    private static void splitCal(String str) {
        matcher = checkRegexPattern(str, CUSTOM_DELIMETER_REGEX);
        if (matcher.find()) {
            SPLIT_REGEX = matcher.group(1);
            str = matcher.group(2);
        }
        strSplitArr = str.split(SPLIT_REGEX);
    }

    private static int sumCal(String[] strSplitArr) {
        int resultSum = 0;
        for (String s : strSplitArr) {
            checkNumRange(s);
            resultSum += Integer.parseInt(s);
        }
        return resultSum;
    }

    private static Matcher checkRegexPattern(String str, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(str);
    }

    // #. 숫자 이외의 값 또는 음수값일 경우 RuntimeException 발생
    private static void checkNumRange(String strSplitArrElement) {
        matcher = checkRegexPattern(strSplitArrElement, NUM_REGEX);
        if (!matcher.find()) {
            throw new RuntimeException(ERR_MSG_MINUS);
        }
    }
}


