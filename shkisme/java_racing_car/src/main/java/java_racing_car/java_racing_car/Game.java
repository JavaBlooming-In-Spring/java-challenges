package java_racing_car.java_racing_car;

import static java_racing_car.java_racing_car.Game.GameMessage.FINAL_WINNER;
import static java_racing_car.java_racing_car.Game.GameMessage.PRINT_RESULT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.util.StringUtils;

public class Game {
  User user;
  GameController gameController;
  Random random = new Random();
  List<String> winnerList = new ArrayList<>();
  Game(User user, GameController gameController){
    this.user = user;
    this.gameController = gameController;
    this.winnerList = winnerList;
  }
  public void mainGame(){
    int tryNumber = Integer.parseInt(user.getTryNumber());

    for (int i = 0; i< tryNumber; i++){
      for (Car car : gameController.getCarList()){
        if (isNumberGreaterThanFour(generateRandomNumber())){
          car.plusScore();
        }
      }
      if (i == 0){
        System.out.println(PRINT_RESULT.getMessage());
      }
      printScore();
    }
    generateWinnerList(getHighestScore());
    printWinner();
  }
  private int generateRandomNumber(){
    int randomNumber = random.nextInt(10);
    return randomNumber;
  }
  private boolean isNumberGreaterThanFour(int randomNumber){
    if (randomNumber >= 4){
      return true;
    }
    return false;
  }
  private void printScore(){
    for (Car car : gameController.getCarList()){
      System.out.printf("%s : ",car.getCarName());
      for (int i = 0 ; i< car.getScore(); i++){
        System.out.print("-");
      }
      System.out.println("\n");
    }
    System.out.println("\n");
  }
  public int getHighestScore(){
    List<Integer> list = new ArrayList<>();
    for (Car car : gameController.getCarList()){
      list.add(car.getScore());
    }
    int max = Collections.max(list);
    return max;
  }
  public void generateWinnerList(int highestScore){
    for (Car car : gameController.getCarList()){
      if (car.getScore() == highestScore){
        winnerList.add(car.getCarName());
      }
    }
  }
  private void printWinner(){
    System.out.printf("%s : ", FINAL_WINNER.getMessage());
    System.out.println(String.join(",",winnerList));
  }

  enum GameMessage{
    PRINT_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자");
    private String message;
    GameMessage(String message){
      this.message = message;
    }
    public String getMessage(){
      return this.message;
    }
  }
}
