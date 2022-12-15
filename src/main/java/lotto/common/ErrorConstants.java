package lotto.common;

public class ErrorConstants {
  public enum MoneyError {
    EMPTY_STR_ERR, NEGATIVE_NUM_ERR, INVALID_FORMAT_ERR
  }

  public enum WinningNumError {
    EMPTY_STR_ERR, ARR_LENGTH_ERR, NUM_RANGE_ERR, INVALID_FORMAT_ERR
  }

  public static final String EMPTY_STR_ERR_STRING = "빈 문자열은 사용할 수 없습니다.";
  public static final String NEGATIVE_NUM_ERR_STRING = "구입 금액은 양수만 입력 가능합니다.";
  public static final String INVALID_FORMAT_ERR_STRING = "금액 및 번호는 숫자만 입력이 가능합니다.";
  public static final String ARR_LENGTH_ERR_STRING = "지난 주 당첨 번호는 6자리로 입력해주세요.";
  public static final String NUM_RANGE_ERR_STRING = "지난 주 당첨 번호는 1 - 45 의 숫자를 ',' 로 구분하여 적어주세요.";
}
