package java_racing_car.java_racing_car;

import java.util.Scanner;


public class User {
    private String carName;
    private String[] carList;
    private String tryNumber;
    public static Scanner sc = new Scanner(System.in);

    User(){
        this.carName = carName;
        this.carList =  carList;
        this.tryNumber = tryNumber;
    }
    public void closeScanner(){
        sc.close();
    }
    public void setCarName(){
        carName = "";
    }
    public void setTryNumber(){
        tryNumber = "";
    }
    public void userInputCarName(){
        carName = sc.nextLine();
    }

    public void userInputTryNumber(){
        tryNumber = sc.nextLine();
    }
    public String getCarName(){
        return carName;
    }
    public String getTryNumber(){
        return tryNumber;
    }
    public String[] getCarNameList(){
        return carList;
    }
    public void saveCarList(String[] array){
        this.carList = array;
    }

}
