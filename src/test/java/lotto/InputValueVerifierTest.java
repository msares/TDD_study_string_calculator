package lotto;

import lotto.model.InputValueVerifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueVerifierTest {
  static InputValueVerifier inputValueVerifier;

  @BeforeAll
  public static void beforeAll() {
    inputValueVerifier = new InputValueVerifier();
  }

  @Test
  public void 구매금액() {
    assertThat(inputValueVerifier.verifyInputMoney("14000")).isTrue();
  }

  @Test
  public void 구매금액_문자포함() {
    assertThatThrownBy(
      () -> inputValueVerifier.verifyInputMoney("14000a"))
      .isInstanceOf(NumberFormatException.class);
  }

  @Test
  public void 구매금액_공백() {
    assertThat(inputValueVerifier.verifyInputMoney("  ")).isFalse();
  }

  @Test
  public void 구매금액_음수() {
    assertThat(inputValueVerifier.verifyInputMoney("-123")).isFalse();
  }

  @Test
  public void 지난주_당첨번호() {
    String winningNum = "1,1,1,1,1,1";
    assertThat(inputValueVerifier.verifyWinningNumbers(winningNum)).isTrue();
  }

  @Test
  public void 지난주_당첨번호_문자열포함() {
    String winningNum = "1,a,1,1,1,1";
    assertThatThrownBy( // hasMessageContaining()
      () -> inputValueVerifier.verifyWinningNumbers(winningNum))
      .isInstanceOf(NumberFormatException.class);
  }

  @Test
  public void 지난주_당첨번호_공백포함() {
    String winningNum = "1, ,1,1,1,1";
    assertThatThrownBy( // hasMessageContaining()
      () -> inputValueVerifier.verifyWinningNumbers(winningNum))
      .isInstanceOf(NumberFormatException.class);
  }

  @Test
  public void 지난주_당첨번호_번호_개수_부족() {
    String winningNum = "1,1,1,1,1";
    assertThat(inputValueVerifier.verifyWinningNumbers(winningNum)).isFalse();
  }

  @Test
  public void 지난주_당첨번호_번호_개수_초과() {
    String winningNum = "1,1,1,1,1,1,1,1,1";
    assertThat(inputValueVerifier.verifyWinningNumbers(winningNum)).isFalse();
  }

  @Test
  public void 지난주_당첨번호_범위_초과() {
    String winningNum = "46,1,1,1,1,1";
    assertThat(inputValueVerifier.verifyWinningNumbers(winningNum)).isFalse();
  }


}
