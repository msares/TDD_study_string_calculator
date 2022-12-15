package lotto.view;

import lotto.common.ErrorConstants;
import lotto.common.ErrorConstants.MoneyError;
import lotto.common.ErrorConstants.WinningNumError;
import lotto.model.ScoreInformation;

public class OutputView {
  public OutputView() {

  }

  public void printWinningAward(ScoreInformation scoreInfo) {
    System.out.println(ViewConstants.OUTPUT_WINNING_AVG_STR);
    System.out.println(ViewConstants.OUTPUT_3_MATCHING_REWARD + scoreInfo.getWin3Cnt());
    System.out.println(ViewConstants.OUTPUT_4_MATCHING_REWARD + scoreInfo.getWin4Cnt());
    System.out.println(ViewConstants.OUTPUT_5_MATCHING_REWARD + scoreInfo.getWin5Cnt());
    System.out.println(ViewConstants.OUTPUT_6_MATCHING_REWARD + scoreInfo.getWin6Cnt());
  }

  public void printRevenueRatio(double ratio) {
    System.out.println("총 수익률은 " + ratio + "입니다.");
  }

  public void printMoneyErrorMessage(MoneyError errorType) {
    if (errorType == MoneyError.EMPTY_STR_ERR) {
      System.out.println(ErrorConstants.EMPTY_STR_ERR_STRING);
    }
    if (errorType == MoneyError.NEGATIVE_NUM_ERR) {
      System.out.println(ErrorConstants.NEGATIVE_NUM_ERR_STRING);
    }
    if (errorType == MoneyError.INVALID_FORMAT_ERR) {
      System.out.println(ErrorConstants.INVALID_FORMAT_ERR_STRING);
    }
  }

  public void printWinNumErrorMessage(WinningNumError errorType) {
    if (errorType == WinningNumError.EMPTY_STR_ERR) {
      System.out.println(ErrorConstants.EMPTY_STR_ERR_STRING);
    }
    if (errorType == WinningNumError.NUM_RANGE_ERR) {
      System.out.println(ErrorConstants.NUM_RANGE_ERR_STRING);
    }
    if (errorType == WinningNumError.ARR_LENGTH_ERR) {
      System.out.println(ErrorConstants.ARR_LENGTH_ERR_STRING);
    }
    if (errorType == WinningNumError.INVALID_FORMAT_ERR) {
      System.out.println(ErrorConstants.INVALID_FORMAT_ERR_STRING);
    }
  }
}
