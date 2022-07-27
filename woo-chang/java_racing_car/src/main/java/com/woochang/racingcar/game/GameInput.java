package com.woochang.racingcar.game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameInput {

  private static final Scanner scanner = new Scanner(System.in);

  public static String nextLine() {
    return scanner.nextLine();
  }

  public static List<String> parseCars(String input) {
    return Arrays.stream(input.split(",")).collect(Collectors.toList());
  }

  public static void close() {
    scanner.close();
  }

}
