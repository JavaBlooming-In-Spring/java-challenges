import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameHelper {
  
  private String input;
  private int strike;
  private int ball;

  public void userInput() {
    do {
      System.out.print("예상하는 수를 입력해주세요 : ");
      input = GameUtils.SCANNER.next();
      GameUtils.SCANNER.nextLine();
    } while(!verifyInput(input));
  }

  private boolean verifyInput(String input) {
    return isValidInputLength(input) && isNumericAndNotDuplicateInput(input);
  }

  private boolean isValidInputLength(String input) {
    if(input.length() != GameUtils.MAX_LENGTH) {
      System.out.println("3자리 수를 입력해주세요.");
      return false;
    }
    return true;
  }

  private boolean isNumericAndNotDuplicateInput(String input) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < input.length(); i++) {
      if (!isNumeric(input.charAt(i)) || isDuplicate(set, input.charAt(i))) {
        return false;
      }
      set.add(input.charAt(i));
    }
    return true;
  }

  private boolean isNumeric(char target) {
    if(Character.isDigit(target)) {
      return true;
    }
    System.out.println("숫자만 입력해주세요.");
    return false;
  }

  private boolean isDuplicate(Set<Character> set, char target) {
    if(set.contains(target)) {
      System.out.println("중복은 허용되지 않습니다.");
      return true;
    }
    return false;
  }

  public void compareInput(String target) {
    Character[] characters = target.chars().mapToObj(s -> (char)s).toArray(Character[]::new);
    List<Character> targets = Arrays.stream(characters).collect(Collectors.toList());
    strike = 0;
    ball = 0;
    for(int i = 0; i < input.length(); i++) {
      if(input.charAt(i) == targets.get(i)) {
        strike += 1;
      } else {
        if(targets.contains(input.charAt(i))) {
          ball += 1;
        }
      }
    }
  }

  public boolean isNotGameOver() {
    if(strike == 3) {
      System.out.println("정답!");
      return false;
    }
    if(strike == 0 && ball == 0) {
      System.out.println("낫싱!");
    } else {
      System.out.println(strike + "S" + ball + "B");
    }
    return true;
  }

}
