import domain.Rank;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class LottoOutput {

  public static void print(String message) {
    System.out.println(message);
  }

  public static void finalResultPrint(Map<Rank, Long> result) {
    result.entrySet().stream()
        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        .filter(entry -> entry.getKey().getMatch() != 0)
        .forEach(LottoOutput::rankCasePrint);
  }

  private static void rankCasePrint(Entry<Rank, Long> entry) {
    LottoOutput.print(entry.getKey().getMatch() + "개 일치 (" + entry.getKey().getPrice() + "원)-" + entry.getValue() + "개");
  }

}
