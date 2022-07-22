package javablooming.domain;

public class Car {

  String name;
  int position = 0;

  public Car(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void moveForward() {
    position++;
  }
}
