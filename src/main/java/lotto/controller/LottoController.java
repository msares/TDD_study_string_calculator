package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoCreator;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
  LottoCreator lottoCreator;

  public LottoController() {
    lottoCreator = new LottoCreator();
  }


  public List<Lotto> createLottoList(int lottCnt) {
    List<Lotto> lottoList = new ArrayList<>();
    for (int i = 0; i < lottCnt; i++) {
      lottoList.add(lottoCreator.createLotto());
    }
    return lottoList;
  }

}
