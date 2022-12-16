package TDD_study_lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPaper {

    public LottoPaper() {
    }

    private List<Integer> makeBaseLottoNums() {
        List<Integer> baseLottoNums = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            baseLottoNums.add(i);
        }
        return new Lotto(baseLottoNums).getLotto();
    }

    public Lotto makeLottoRow() {
        List<Integer> lottoNums = makeBaseLottoNums();
        Collections.shuffle(lottoNums);
        return new Lotto(lottoNums.subList(0, 6));
    }

    public List<Lotto> makeLottoRows(int dividedMoney) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < dividedMoney; i++) {
            lottoList.add(makeLottoRow());
        }
        return lottoList;
    }
}
