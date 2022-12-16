package TDD_study_lotto.common;

import java.util.HashMap;
import java.util.Map;

public class LottoUtil {

    public LottoUtil() {
    }
    public static final int[] winMoneyInfo = new int[]{5000, 50000, 1500000, 2000000000};

    public Map<Integer, Integer> winRankInfo = new HashMap<Integer, Integer>() {{
        put(3, 0);
        put(4, 0);
        put(5, 0);
        put(6, 0);
    }};

}
