package lotto.model;

import lotto.common.LottoConstants.MatchingScore;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScoreManager {
  List<Lotto> lottos;
  List<Integer> winningNumbers;

  public ScoreManager(List<Lotto> lottos, List<Integer> winningNumbers) {
    this.lottos = lottos;
    this.winningNumbers = winningNumbers;
  }

  public ScoreInformation getScore() {
    ScoreInformation scoreInformation = new ScoreInformation();
    for (Lotto lotto : lottos) {
      int matchingCnt = compareValue(lotto);
      scoreInformation.addScore(getMatchingScore(matchingCnt));
    }
    return scoreInformation;
  }

  private int compareValue(Lotto lotto) {
    List<Integer> lottoNumber = new CopyOnWriteArrayList(lotto.getNumbers());
    lottoNumber.retainAll(winningNumbers);
    return lottoNumber.size();
  }

  private MatchingScore getMatchingScore(int matchingNum) {
    if (matchingNum == 3) {
      return MatchingScore.MATCH_3;
    }
    if (matchingNum == 4) {
      return MatchingScore.MATCH_4;
    }
    if (matchingNum == 5) {
      return MatchingScore.MATCH_5;
    }
    if (matchingNum == 6) {
      return MatchingScore.MATCH_6;
    }
    return MatchingScore.NONE;
  }
}
