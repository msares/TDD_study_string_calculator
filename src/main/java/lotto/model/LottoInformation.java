package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoInformation {
  public int money;
  public List<Integer> winningNumbers;
  public List<Lotto> lottos;

  public LottoInformation() {
    winningNumbers = new ArrayList<>();
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public List<Integer> getWinningNumbers() {
    return winningNumbers;
  }

  public void addWinningNumbers(int number) {
    winningNumbers.add(number);
  }

  public void setWinningNumbers(List<Integer> winningNumbers) {
    this.winningNumbers = winningNumbers;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public void setLottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public void addLottos(Lotto lotto) {
    if (lottos == null) {
      lottos = new ArrayList<>();
    }
    lottos.add(lotto);
  }
}
