package lotto;

import lotto.model.Lotto;
import lotto.model.LottoCreator;
import lotto.common.LottoConstants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreatorTest {
  static Lotto lotto;
  static List<Integer> numbers;

  @BeforeAll
  public static void beforeAll() {
    LottoCreator lottoCreator = new LottoCreator();
    lotto = lottoCreator.createLotto();
    numbers = lotto.getNumbers();
  }

  @Test
  public void 로또생성_길이_검증() {
    assertThat(numbers.size()).isEqualTo(LottoConstants.LOTTO_NUM_LENGTH);
  }

  @Test
  public void 로또생성_번호범위_검증() {
    for (int number : numbers) {
      assertThat(number).isGreaterThan(LottoConstants.NUM_ZERO);
      assertThat(number).isLessThan(LottoConstants.MAX_LOTTO_NUM);
    }
  }

}
