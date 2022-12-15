package lotto.model;

import lotto.common.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {
  public LottoCreator() {
  }

  public Lotto createLotto() {
    List<Integer> numList = setNumbers();
    Collections.shuffle(numList);
    return new Lotto(numList.subList(LottoConstants.NUM_ZERO, LottoConstants.LOTTO_NUM_LENGTH));
  }

  private List<Integer> setNumbers() {
    List<Integer> numList = new ArrayList<>();
    for (int i = 1; i <= LottoConstants.MAX_LOTTO_NUM; i++) {
      numList.add(i);
    }
    return numList;
  }
}
