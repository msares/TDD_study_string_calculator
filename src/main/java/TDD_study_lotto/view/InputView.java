package TDD_study_lotto.view;

import TDD_study_lotto.common.MessageUtil;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    public int inputMoney() {
        System.out.println(MessageUtil.INPUT_MONEY);
        return scanner.nextInt();
    }

    public String inputWinNumbers(){
        System.out.println(MessageUtil.INPUT_LAST_WEEK_WIN_NUMBERS);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
