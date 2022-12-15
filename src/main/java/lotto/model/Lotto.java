package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
  public List<Integer> numbers;

  public Lotto() {
  }

  public Lotto(List<Integer> lottoNumbers) {
    this.numbers = lottoNumbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public void addNumbers(int number) {
    if (numbers == null) {
      numbers = new ArrayList<>();
    }
    numbers.add(number);
  }

}
