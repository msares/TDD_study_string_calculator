package lotto.view;

import java.util.Scanner;

public class InputView {
  Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public String inputPurchaseAmount() {
    System.out.println(ViewConstants.INPUT_PURCHASE_AMOUNT_STR);
    return scanner.nextLine();
  }

  public String inputWinningNumbers() {
    System.out.println(ViewConstants.INPUT_WINNING_NUMBER_STR);
    return scanner.nextLine();
  }
}
