package lotto.common;

public class LottoConstants {
  public static final String DELIMITER = ",";
  public static final int SINGLE_LOTTO_COST = 1000;
  public static final int NUM_ZERO = 0;
  public static final int LOTTO_NUM_LENGTH = 6;
  public static final int MIN_LOTTO_NUM = 1;
  public static final int MAX_LOTTO_NUM = 45;
  public static final int REWARD_WIN_3 = 5000;
  public static final int REWARD_WIN_4 = 50000;
  public static final int REWARD_WIN_5 = 1500000;
  public static final int REWARD_WIN_6 = 2000000000;

  public enum errorType {
    ERROR_INPUT_MONEY, ERROR_INPUT_WINNING_NUM
  }

  public enum MatchingScore {
    NONE, MATCH_3, MATCH_4, MATCH_5, MATCH_6
  }
}
