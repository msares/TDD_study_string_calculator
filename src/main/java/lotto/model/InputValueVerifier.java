package lotto.model;

import lotto.common.ErrorConstants.MoneyError;
import lotto.common.ErrorConstants.WinningNumError;
import lotto.common.LottoConstants;
import lotto.view.OutputView;

public class InputValueVerifier {
  LottoInformation lottoInfo;
  OutputView outputView;

  public InputValueVerifier() {
    lottoInfo = new LottoInformation();
    outputView = new OutputView();
  }

  public boolean verifyInputMoney(String input) {
    if (isEmptyString(input)) {
      outputView.printMoneyErrorMessage(MoneyError.EMPTY_STR_ERR);
      return false;
    }
    Integer money = StringConverter(input);
    if (money == null) {
      return false;
    }
    if (isPositiveNumber(money)) {
      lottoInfo.setMoney(money);
      return true;
    }
    outputView.printMoneyErrorMessage(MoneyError.NEGATIVE_NUM_ERR);
    return false;
  }

  public boolean verifyWinningNumbers(String input) {
    if (isEmptyString(input)) {
      outputView.printWinNumErrorMessage(WinningNumError.EMPTY_STR_ERR);
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

  private Integer StringConverter(String inputStr) {
    try {
      return Integer.parseInt(inputStr.trim());
    } catch (NumberFormatException e) {
      outputView.printMoneyErrorMessage(MoneyError.INVALID_FORMAT_ERR);
      return null;
    }
  }

  private boolean verifyArrays(String[] numberArr) {
    if (!verifyArrayLength(numberArr)) {
      outputView.printWinNumErrorMessage(WinningNumError.ARR_LENGTH_ERR);
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
    Integer num = StringConverter(inputStr);
    if (num == null) {
      return;
    }
    if (!verifyNumberRange(num)) {
      outputView.printWinNumErrorMessage(WinningNumError.NUM_RANGE_ERR);
      return;
    }
    lottoInfo.addWinningNumbers(num);
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
