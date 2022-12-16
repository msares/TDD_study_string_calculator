package TDD_study_lotto.model;
import TDD_study_lotto.common.LottoUtil;
import TDD_study_lotto.common.MessageUtil;

import java.util.*;

public class WinLotto {
    public WinLotto() {
    }
     Map<Integer, Integer> winRankInfo = new LottoUtil().winRankInfo;

    public static int sumReturnMoney(Map<Integer, Integer> resultLotto) {
        int totalSum = 0;
        for (int i = MessageUtil.START_WIN_NUMBER; i < MessageUtil.FINAL_WIN_NUMBER; i++) {
            totalSum += (resultLotto.get(i) * LottoUtil.winMoneyInfo[i - 3]);
        }
        return totalSum;
    }

    public Map<Integer, Integer> compareWinLotto(List<Integer> winLottoList, List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            List<Integer> myLotto = lotto.getLotto();
            myLotto.removeAll(winLottoList);
            chooseWinRank(winLottoList.size() - myLotto.size());
        }
        return winRankInfo;
    }

    public void chooseWinRank(int sameNumCnt) {
        if (winRankInfo.containsKey(sameNumCnt)) {
            winRankInfo.put(sameNumCnt, winRankInfo.getOrDefault(sameNumCnt, MessageUtil.ZERO_VALUE) + MessageUtil.INCREASE_WIN_COUNT);
        }
    }

    public List<Integer> winLottoList(String winNums) {
        String[] winNumStr = winNums.split(MessageUtil.SPLIT_WIN_NUMBERS);
        List<Integer> winLottoNums = new ArrayList<>();
        for (String str : winNumStr) {
            winLottoNums.add(Integer.parseInt(str));
        }
        return winLottoNums;
    }

    public double totalReturnMoney(int totalSum, int inputMoney) {
        return (double) totalSum / inputMoney;
    }
}
