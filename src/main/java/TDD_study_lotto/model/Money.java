package TDD_study_lotto.model;

import TDD_study_lotto.common.MessageUtil;

public class Money {

    public Money() {
    }

    public int validateMoney(int inputMoney) {
        if(isMinusMoney(inputMoney)){
            throw new IllegalArgumentException(MessageUtil.IMPPOSIBLE_MONEY_VALUE);
        }
        return inputMoney;
    }

    private boolean isMinusMoney(int inputMoney) {
        return inputMoney < MessageUtil.ZERO_VALUE;
    }
}
