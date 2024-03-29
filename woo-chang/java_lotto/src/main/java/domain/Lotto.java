package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return new ArrayList<>(numbers);
  }

  // 추가 기능 구현
  @Override
  public String toString() {
    return numbers.toString();
  }
}
