package lotto.domain;

import static lotto.util.LottoUtil.LENGTH_OF_LOTTO_NUMBERS;
import static lotto.util.LottoUtil.MAX_LOTTO_NUMBER;
import static lotto.util.LottoUtil.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

  private final List<Integer> numbers;

  public static Lotto newInstance() {
    List<Integer> candidateList = new ArrayList<>(IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
        .boxed().toList());
    Collections.shuffle(candidateList);
    return new Lotto(candidateList.subList(0, LENGTH_OF_LOTTO_NUMBERS));
  }

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}