import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

  public static Scanner SCAN = new Scanner(System.in);

  public static String getInput() {
    return SCAN.nextLine();
  }

  public static List<Integer> parseInput(String input) {
    return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
  }

}
