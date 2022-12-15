package lotto.controller;

import lotto.common.LottoConstants.errorType;
import lotto.model.InputValueVerifier;
import lotto.model.Lotto;
import lotto.model.ScoreInformation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class ViewController {
  InputValueVerifier inputValueVerifier;
  InputView inputView;
  OutputView outputView;

  public ViewController() {
    inputValueVerifier = new InputValueVerifier();
    inputView = new InputView();
    outputView = new OutputView();
  }

  public int getInputMoney() {
    boolean inputResult = false;
    while (!inputResult) {
      String inputMoney = inputView.inputPurchaseAmount();
      inputResult = inputValueVerifier.verifyInputMoney(inputMoney);
    }
    return inputValueVerifier.getLottoInformation().getMoney();
  }

  public List<Integer> getWinningNumberList() {
    boolean inputResult = false;
    while (!inputResult) {
      String winningNumbers = inputView.inputWinningNumbers();
      inputResult = inputValueVerifier.verifyWinningNumbers(winningNumbers);
    }
    return inputValueVerifier.getLottoInformation().getWinningNumbers();
  }

  public void printLottos(List<Lotto> lottos){
    for (Lotto lotto : lottos){
      System.out.println(lotto.getNumbers());
    }
  }

  public void printOutputMessage(ScoreInformation winningCnt, double ratio) {
    outputView.printWinningAward(winningCnt);
    outputView.printRevenueRatio(ratio);
  }
}
