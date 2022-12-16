package TDD_study_lotto;

import TDD_study_lotto.controller.LottoInputController;

public class LottoApplication {
    public static void main(String[] args) {
        LottoInputController lottoInputController = new LottoInputController();
        lottoInputController.inputLottoMoney();
    }
}