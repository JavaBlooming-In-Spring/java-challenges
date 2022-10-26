package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

  private static final int ALPHABET_SIZE = 26;
  private static final Map<Character, Character> dictionary = new HashMap<>();

  static {
    for (int i = 0; i < ALPHABET_SIZE; i++) {
      dictionary.put((char) ('a' + i), (char) ('z' - i));
      dictionary.put((char) ('A' + i), (char) ('Z' - i));
    }
  }

  public static String solution(String word) {
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (Character.isAlphabetic(c)) {
        answer.append(dictionary.get(c));
      } else {
        answer.append(c);
      }
    }
    return answer.toString();
  }
}
