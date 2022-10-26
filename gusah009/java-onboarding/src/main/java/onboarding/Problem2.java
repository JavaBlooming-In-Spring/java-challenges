package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

  public static String solution(String cryptogram) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < cryptogram.length(); i++) {
      char currChar = cryptogram.charAt(i);
      boolean pushFlag = true;
      if (i == cryptogram.length() - 1 || currChar != cryptogram.charAt(i + 1)) {
        while (!stack.isEmpty() && currChar == stack.peek()) {
          stack.pop();
          pushFlag = false;
        }
      }
      if (pushFlag) {
        stack.push(currChar);
      }
    }
    return stack.stream()
        .map(Object::toString)
        .collect(Collectors.joining());
  }
}
