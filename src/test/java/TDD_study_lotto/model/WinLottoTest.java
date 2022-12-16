package TDD_study_lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinLottoTest {
    String winNums = "1, 2, 3, 4, 5, 6";
    static final List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void 입력받은_당첨번호_리스트_만들기() {
        WinLotto winLotto = new WinLotto();
        List<Integer> winLottoNums = winLotto.winLottoList(winNums);
        assertThat(winLottoNums.containsAll(winNumbers)).isTrue();
    }
}
