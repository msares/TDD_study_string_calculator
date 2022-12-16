package TDD_study_lotto.view;

import TDD_study_lotto.common.LottoUtil;
import TDD_study_lotto.common.MessageUtil;
import TDD_study_lotto.model.Lotto;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void showBuyLotto(int divideMoney) {
        System.out.println(divideMoney + "개를 구매했습니다.");
    }

    public static void showLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void showWinLotto(String winNums) {
        System.out.println(winNums);
    }

    public static void showResultLotto(Map<Integer, Integer> resultLotto) {

        System.out.println(MessageUtil.WIN_PERCENTAGE);
        System.out.println("---------------");
        for (int i = MessageUtil.START_WIN_NUMBER; i < MessageUtil.FINAL_WIN_NUMBER; i++) {
            System.out.println(i + "개 일치 (" + LottoUtil.winMoneyInfo[i - 3] + ")-" + resultLotto.get(i) + "개");
        }
    }

    public static void showReturnPercent(double returnPercent) {
        System.out.println(returnPercent);
    }
}
