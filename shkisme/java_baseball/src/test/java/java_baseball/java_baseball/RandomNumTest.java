package java_baseball.java_baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumTest {
    @Test
    @DisplayName("랜덤 수 생성 테스트 1")
    public void randomGenerate1(){
        Computer computer = new Computer();

        computer.generateRandomNum();
        List<Integer> randomNumList = computer.getRandomNumList();
        System.out.println(randomNumList.get(0));
        System.out.println(randomNumList.get(1));
        System.out.println(randomNumList.get(2));
    }
    @Test
    @DisplayName("랜덤 수 생성 테스트 2")
    public void randomGenerate2(){
        Computer computer = new Computer();

        computer.generateRandomNum();
        List<Integer> randomNumList = computer.getRandomNumList();
        System.out.println(randomNumList.get(0));
        System.out.println(randomNumList.get(1));
        System.out.println(randomNumList.get(2));
    }
}
