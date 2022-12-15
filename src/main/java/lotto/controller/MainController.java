package lotto.controller;

import lotto.common.LottoConstants;
import lotto.model.Lotto;
import lotto.model.ScoreInformation;
import lotto.model.ScoreManager;

import java.util.List;

public class MainController {
  LottoController lottoController;
  ViewController viewController;

  public MainController() {
    lottoController = new LottoController();
    viewController = new ViewController();
  }

  public void buyLotto() {
    int inputMoney = viewController.getInputMoney();
    List<Lotto> lottos = lottoController.createLottoList(getLottoCnt(inputMoney));
    viewController.printLottos(lottos);
    List<Integer> winningNumbers = viewController.getWinningNumberList();
    ScoreManager scoreManager = new ScoreManager(lottos, winningNumbers);
    ScoreInformation scoreInfo = scoreManager.getScore();
    double ratio = getRatio(inputMoney, getReward(scoreInfo));
    viewController.printOutputMessage(scoreInfo, ratio);
  }

  public int getLottoCnt(int money) {
    return money / LottoConstants.SINGLE_LOTTO_COST;
  }

  public int getReward(ScoreInformation scoreInfo) {
    int reward = (scoreInfo.getWin3Cnt() * LottoConstants.REWARD_WIN_3)
      + (scoreInfo.getWin4Cnt() * LottoConstants.REWARD_WIN_4)
      + (scoreInfo.getWin5Cnt() * LottoConstants.REWARD_WIN_5)
      + (scoreInfo.getWin6Cnt() * LottoConstants.REWARD_WIN_6);
    return reward;
  }

  public double getRatio(int money, int reward) {
    return (double) reward / money;
  }
}
