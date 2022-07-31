import domain.Lotto;
import domain.util.LottoGuide;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGenerator {

  public static List<Lotto> generateLottos(long count) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 1; i <= count; i++) {
      lottos.add(generateLotto());
    }
    return lottos;
  }

  private static Lotto generateLotto() {
    Random random = new Random();
    Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < LottoGuide.COUNT.getValue()) {
      numbers.add(random.nextInt(LottoGuide.HIGH_NUM.getValue() + 1));
    }
    List<Integer> lottoNumbers = numbers.stream()
        .sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    return new Lotto(lottoNumbers);
  }

  public static Lotto loadingLastWeekLotto(String input) {
    List<Integer> lastWeekLotto = Arrays.stream(input.split(",")).map(Integer::parseInt)
        .sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    return new Lotto(lastWeekLotto);
  }

}
