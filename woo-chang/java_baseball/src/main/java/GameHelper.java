import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameHelper {
  
  private String input;
  private int[] inputResult = new int[GameUtils.TARGET_LENGTH];
  private int strike;
  private int ball;

  public void userInput() {
    System.out.print("예상하는 수를 입력해주세요 : ");
    input = GameUtils.SCANNER.next();
    GameUtils.SCANNER.nextLine();
  }

  public boolean isInvalidInput() {
    return isInValidInputLength() || isNotNumericOrDuplicateInput();
  }

  private boolean isInValidInputLength() {
    if(input.length() != GameUtils.TARGET_LENGTH) {
      System.out.println(GameUtils.TARGET_LENGTH + "자리 수를 입력해주세요.");
      return true;
    }
    return false;
  }

  private boolean isNotNumericOrDuplicateInput() {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < input.length(); i++) {
      if (isNotNumeric(input.charAt(i)) || isDuplicate(set, input.charAt(i))) {
        return true;
      }
      set.add(input.charAt(i));
    }
    return false;
  }

  private boolean isNotNumeric(char target) {
    if(Character.isDigit(target)) {
      return false;
    }
    System.out.println("숫자만 입력해주세요.");
    return true;
  }

  private boolean isDuplicate(Set<Character> set, char target) {
    if(set.contains(target)) {
      System.out.println("중복은 허용되지 않습니다.");
      return true;
    }
    return false;
  }

  public void setInput() {
    inputResult = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
  }

  public void compareInput(List<Integer> target) {
    strike = 0;
    ball = 0;
    for(int i = 0; i < GameUtils.TARGET_LENGTH; i++) {
      if(inputResult[i] == target.get(i)) {
        strike += 1;
      } else {
        if(target.contains(inputResult[i])) {
          ball += 1;
        }
      }
    }
  }

  public boolean isNotGameOver() {
    if(strike == GameUtils.TARGET_LENGTH) {
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
