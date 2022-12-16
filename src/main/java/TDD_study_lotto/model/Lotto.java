package TDD_study_lotto.model;

import java.util.List;

public class Lotto {
    List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
