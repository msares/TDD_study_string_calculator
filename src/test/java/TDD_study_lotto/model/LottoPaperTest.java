package TDD_study_lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {

    @Test
    void 로또_한개_발급() {
        LottoPaper lottoPaper = new LottoPaper();
        Lotto lotto = lottoPaper.makeLottoRow();
        for (Integer lottoNum : lotto.getLotto()) {
            assertThat(lottoNum).isBetween(1, 45);
        }
    }

    @Test
    void 입금받은_금액_나누기_천원만큼_발급() {
        LottoPaper lottoPaper = new LottoPaper();
        List<Lotto> lottoList = lottoPaper.makeLottoRows(14);
        assertThat(lottoList.size()).isEqualTo(14);
    }
}
