package TDD_study_lotto.controller;

import TDD_study_lotto.model.Lotto;
import TDD_study_lotto.model.LottoPaper;
import TDD_study_lotto.model.Money;
import TDD_study_lotto.model.WinLotto;
import TDD_study_lotto.view.InputView;
import TDD_study_lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoInputController {
    InputView inputView = new InputView();
    Money money = new Money();
    WinLotto winLotto = new WinLotto();
    LottoPaper lottoPaper = new LottoPaper();

    public void inputLottoMoney() {
        int inputMoney = inputView.inputMoney();
        money.validateMoney(inputMoney);
        int dividedMoney = divideMoney(inputMoney);
        ResultView.showBuyLotto(dividedMoney);

        // 로또 만들기
        List<Lotto> lottoList = lottoPaper.makeLottoRows(dividedMoney);
        ResultView.showLotto(lottoList);

        // 전달받은 로또 번호 LIST화 시키기
        String winNums = inputView.inputWinNumbers();
        List<Integer> winLottoList = winLotto.winLottoList(winNums);
        ResultView.showWinLotto(winNums);

        //만든 로또 번호 비교하기
        Map<Integer, Integer> resultLotto = winLotto.compareWinLotto(winLottoList, lottoList);
        ResultView.showResultLotto(resultLotto);

        //수익률 분석하기
        int totalSum = WinLotto.sumReturnMoney(resultLotto);
        double returnPercent = winLotto.totalReturnMoney(totalSum, inputMoney);
        ResultView.showReturnPercent(returnPercent);
    }

    public int divideMoney(int inputMoney) {
        return inputMoney / 1000;
    }
}
