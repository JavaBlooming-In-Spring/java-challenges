package lotto;

import static lotto.domain.Lotto.generateLotto;
import static lotto.service.PrintService.printMessage;
import static lotto.util.LottoUtil.LOTTO_PRICE;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.InputService;
import lotto.service.LottoService;

public class Main {

  public static void main(String[] args) {
    LottoService lottoService = new LottoService();
    lottoService.play();
  }
}
