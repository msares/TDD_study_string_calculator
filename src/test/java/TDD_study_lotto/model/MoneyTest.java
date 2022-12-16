package TDD_study_lotto.model;

import TDD_study_lotto.common.MessageUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void 입력받은_금액_검증() {
        Money money = new Money();
        assertThat(money.validateMoney(14000)).isEqualTo(14000);
    }

    @Test
    void 입력받은_금액이_0보다_작은_경우() {
        Money money = new Money();
        assertThatThrownBy(() -> money.validateMoney(-14000))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(MessageUtil.IMPPOSIBLE_MONEY_VALUE);
    }
}
