package lotto;

import lotto.model.Lotto;
import lotto.model.ScoreInformation;
import lotto.model.ScoreManager;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreManagerTest {
  List<Lotto> lottos;
  Lotto lotto;

  @BeforeEach
  public void before() {
    lotto = new Lotto();
    lotto.addNumbers(1);
    lotto.addNumbers(2);
    lotto.addNumbers(3);
    lotto.addNumbers(4);
    lotto.addNumbers(5);
    lotto.addNumbers(6);

    lottos = new ArrayList<>();
    lottos.add(lotto);
  }

  @Test
  public void 로또_당첨안됨() {
    Integer[] numbers = {1, 1, 1, 1, 1, 1};
    List<Integer> winNum = Lists.newArrayList(numbers);

    ScoreManager scoreManager = new ScoreManager(lottos, winNum);
    ScoreInformation scoreInformation = scoreManager.getScore();
    assertThat(scoreInformation.getWin3Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin4Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin5Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin6Cnt()).isEqualTo(0);
  }

  @Test
  public void 로또_3개맞음() {
    Integer[] numbers = {1, 2, 3, 1, 1, 1};
    List<Integer> winNum = Lists.newArrayList(numbers);

    ScoreManager scoreManager = new ScoreManager(lottos, winNum);
    ScoreInformation scoreInformation = scoreManager.getScore();
    assertThat(scoreInformation.getWin3Cnt()).isEqualTo(1);
    assertThat(scoreInformation.getWin4Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin5Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin6Cnt()).isEqualTo(0);
  }

  @Test
  public void 로또_4개맞음() {
    Integer[] numbers = {1, 2, 3, 4, 1, 1};
    List<Integer> winNum = Lists.newArrayList(numbers);

    ScoreManager scoreManager = new ScoreManager(lottos, winNum);
    ScoreInformation scoreInformation = scoreManager.getScore();
    assertThat(scoreInformation.getWin3Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin4Cnt()).isEqualTo(1);
    assertThat(scoreInformation.getWin5Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin6Cnt()).isEqualTo(0);
  }

  @Test
  public void 로또_5개맞음() {
    Integer[] numbers = {1, 2, 3, 4, 5, 1};
    List<Integer> winNum = Lists.newArrayList(numbers);

    ScoreManager scoreManager = new ScoreManager(lottos, winNum);
    ScoreInformation scoreInformation = scoreManager.getScore();
    assertThat(scoreInformation.getWin3Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin4Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin5Cnt()).isEqualTo(1);
    assertThat(scoreInformation.getWin6Cnt()).isEqualTo(0);
  }

  @Test
  public void 로또_6개맞음() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6};
    List<Integer> winNum = Lists.newArrayList(numbers);

    ScoreManager scoreManager = new ScoreManager(lottos, winNum);
    ScoreInformation scoreInformation = scoreManager.getScore();
    assertThat(scoreInformation.getWin3Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin4Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin5Cnt()).isEqualTo(0);
    assertThat(scoreInformation.getWin6Cnt()).isEqualTo(1);
  }
}
