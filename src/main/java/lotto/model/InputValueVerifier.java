package lotto.model;

import lotto.common.LottoConstants;

public class InputValueVerifier {
  LottoInformation lottoInfo;

  public InputValueVerifier() {
    lottoInfo = new LottoInformation();
  }

  public boolean verifyInputMoney(String input) {
    if (isEmptyString(input)) {
      return false;
    }
    int money = StringConverter(input);
    if (isPositiveNumber(money)) {
      lottoInfo.setMoney(money);
      return true;
    }
    return false;
  }

  public boolean verifyWinningNumbers(String input) {
    if (isEmptyString(input)) {
      return false;
    }
    String[] winningNumberArr = input.split(LottoConstants.DELIMITER);
    if (!verifyArrays(winningNumberArr)) {
      return false;
    }
    if (lottoInfo.getWinningNumbers().size() != LottoConstants.LOTTO_NUM_LENGTH) {
      return false;
    }
    return true;
  }

  private boolean isEmptyString(String inputStr) {
    return inputStr.trim().isEmpty();
  }

  private boolean isPositiveNumber(int inputNumber) {
    return LottoConstants.NUM_ZERO <= inputNumber;
  }

  private int StringConverter(String inputStr) {
    try {
      return Integer.parseInt(inputStr.trim());
    } catch (NumberFormatException e) {
      throw e;
    }
  }

  private boolean verifyArrays(String[] numberArr) {
    if (!verifyArrayLength(numberArr)) {
      return false;
    }
    setWinningNumbers(numberArr);
    return true;
  }

  private boolean verifyArrayLength(String[] numberArr) {
    return numberArr.length == LottoConstants.LOTTO_NUM_LENGTH;
  }

  private boolean verifyNumberRange(int number) {
    return LottoConstants.MIN_LOTTO_NUM <= number && number <= LottoConstants.MAX_LOTTO_NUM;
  }

  private void verifyNumbers(String inputStr) {
    int num = StringConverter(inputStr);
    if (verifyNumberRange(num)) {
      lottoInfo.addWinningNumbers(num);
    }
  }

  private void setWinningNumbers(String[] numberArr) {
    for (String num : numberArr) {
      verifyNumbers(num);
    }
  }

  public LottoInformation getLottoInformation() {
    return lottoInfo;
  }
}
