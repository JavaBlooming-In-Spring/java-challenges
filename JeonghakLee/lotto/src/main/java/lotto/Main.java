package lotto;

import lotto.service.LottoService;

public class Main {

  public static void main(String[] args) {
    LottoService lottoService = new LottoService();
    lottoService.play();
  }
}
