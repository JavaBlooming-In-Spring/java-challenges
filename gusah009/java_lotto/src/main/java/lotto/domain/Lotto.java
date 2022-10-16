package lotto.domain;

import static lotto.game.GameValidate.MAX_LOTTO_NUM;
import static lotto.game.GameValidate.MIN_LOTTO_NUM;
import static lotto.game.GameValidate.VALID_LOTTO_LENGTH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  // 추가 기능 구현

  public static Lotto newInstance() {
    List<Integer> availableLottoRange = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM + 1)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(availableLottoRange);
    return new Lotto(availableLottoRange.subList(0, VALID_LOTTO_LENGTH));
  }

  public List<Integer> getNumbers() {
    return new ArrayList<>(numbers);
  }
}