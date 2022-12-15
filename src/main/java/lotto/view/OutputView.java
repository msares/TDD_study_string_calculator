package lotto.view;

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

  public void printMoneyErrorMessage() {
    System.out.println(ViewConstants.ERROR_INPUT_MONEY);
  }

  public void printWinNumErrorMessage() {
    System.out.println(ViewConstants.ERROR_INPUT_WINNING_NUM);
  }

}
