package javablooming.service;

import static javablooming.util.GameUtil.InputStatus.FAIL;
import static javablooming.util.GameUtil.InputStatus.SUCCEED;
import static javablooming.util.GameUtil.RacingResult.FORWARD;
import static javablooming.util.GameUtil.RacingResult.STAY;
import static javablooming.util.GameUtil.SCANNER;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javablooming.domain.Car;
import javablooming.util.GameUtil.InputStatus;
import javablooming.util.GameUtil.RacingResult;


public class GamePlay {

  private static final Random random = new Random();
  final List<Car> playerCars = new ArrayList<>();
  private int moveCount = 0;

  int getMoveCount() {
    return moveCount;
  }

  public void input() {
    printGuideMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    while (tryInputCarNames() == FAIL)
      ;
    printGuideMessage("시도할 횟수는 몇회인가요?");
    while (tryInputMoveCount() == FAIL)
      ;
  }

  InputStatus tryInputCarNames() {
    try {
      String playerInput = getPlayerInput();
      setPlayerCars(playerInput);
    } catch (Exception e) {
      playerCars.clear();
      printErrorMessage();
      return FAIL;
    }
    return SUCCEED;
  }

  private void setPlayerCars(String playerInput) {
    String[] playerCarNameArray = playerInput.split(",");
    for (String playerCarName : playerCarNameArray) {
      playerCars.add(new Car(playerCarName));
    }
  }

  private String getPlayerInput() {
    return SCANNER.nextLine();
  }

  private void printErrorMessage() {
    printMessage("유효하지 않은 입력입니다. 재입력 입력하세요.");
  }

  private void printGuideMessage(String s) {
    printMessage(s);
  }

  private void printMessage(String s) {
    System.out.println(s);
  }

  InputStatus tryInputMoveCount() {
    try {
      String playerInput = getPlayerInput();
      setMoveCount(playerInput);
    } catch (Exception e) {
      printErrorMessage();
      return FAIL;
    }
    return SUCCEED;
  }

  private void setMoveCount(String playerInput) {
    moveCount = Integer.parseUnsignedInt(playerInput);
  }

  public void play() {
    printMessage("실행 결과");
    playRacing();
  }

  private void playRacing() {
    for (int i = 0; i < moveCount; i++) {
      playEachRacing();
      printEachRacingResult();
    }
  }

  void printEachRacingResult() {
    for (Car playerCar : playerCars) {
      System.out.println(
          String.format("%5s", playerCar.getName()) + " : " + getPositionToDash(playerCar));
    }
    System.out.println();
  }

  private String getPositionToDash(Car playerCar) {
    // position의 크기만큼 대쉬("-") 생성
    return "-".repeat(playerCar.getPosition());
  }

  private void playEachRacing() {
    for (Car playerCar : playerCars) {
      if (getEachCarRacingResult() == FORWARD) {
        playerCar.moveForward();
      }
    }
  }

  private RacingResult getEachCarRacingResult() {
    int randomNum = random.nextInt(10);
    return getRacingResult(randomNum);
  }

  RacingResult getRacingResult(int randomNum) {
    if (randomNum <= 3) {
      return STAY;
    }
    return FORWARD;
  }

  public void printResult() {
    String firstCarsName = getFirstCarsName();
    printMessage(firstCarsName + "가 최종 우승했습니다.");
  }

  private String getFirstCarsName() {
    List<Car> firstCarList = getFirstCarList();
    List<String> firstCarNameList = castCarNameList(firstCarList);
    return castCarsName(firstCarNameList);
  }

  List<Car> getFirstCarList() {
    int maxPosition = getMaxPosition(playerCars);
    return playerCars.stream()
        .filter(playerCar -> playerCar.getPosition() == maxPosition)
        .toList();
  }

  private int getMaxPosition(List<Car> playerCars) {
    int max = playerCars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .getAsInt();
    return max;
  }

  List<String> castCarNameList(List<Car> firstCarList) {
    return firstCarList.stream()
        .map(Car::getName)
        .toList();
  }

  String castCarsName(List<String> firstCarList) {
    return String.join(", ", firstCarList);
  }
}
