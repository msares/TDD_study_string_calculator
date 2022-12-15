package lotto.model;

import lotto.common.LottoConstants.MatchingScore;

public class ScoreInformation {
  int win3Cnt;
  int win4Cnt;
  int win5Cnt;
  int win6Cnt;

  public ScoreInformation() {
    win3Cnt = 0;
    win4Cnt = 0;
    win5Cnt = 0;
    win6Cnt = 0;
  }

  public void addScore(MatchingScore score) {
    if (score == MatchingScore.MATCH_3) {
      win3Cnt++;
      return;
    }
    if (score == MatchingScore.MATCH_4) {
      win4Cnt++;
      return;
    }
    if (score == MatchingScore.MATCH_5) {
      win5Cnt++;
      return;
    }
    if (score == MatchingScore.MATCH_6) {
      win6Cnt++;
      return;
    }
  }

  public int getWin3Cnt() {
    return win3Cnt;
  }

  public int getWin4Cnt() {
    return win4Cnt;
  }

  public int getWin5Cnt() {
    return win5Cnt;
  }

  public int getWin6Cnt() {
    return win6Cnt;
  }
}
