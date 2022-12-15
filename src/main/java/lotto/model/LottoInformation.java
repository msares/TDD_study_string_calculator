package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoInformation {
  public int money;
  public List<Integer> winningNumbers;

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
}
