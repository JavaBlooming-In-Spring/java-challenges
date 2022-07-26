import static java.util.Collections.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
@Controller
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int strike = 0;
    int ball = 0;
    int initNums[] = {0, 0, 0, 0};
    do
     strike = sc.nextInt();
      ball = sc.nextInt();
      for (int i = 0; i < 4; i++) {
        if (strike == 0) {
          while (strike == 0) {
            initNums[0]++;
          }
        } else if (strike == 1) {
          while (strike == 1) {
            initNums[1]++;
          }
        } else if (strike == 2) {
          while (strike == 2) {
            initNums[2]++;
          }
        } else if (strike == 3) {
          while (strike == 3) {
            initNums[3]++;
          }
        }
      }
    } while (strike != 4);
    for (int i = 0; i < 4; i++) {
      System.out.println(initNums[i] + " ");
    }
    sc.close();
  }
}
