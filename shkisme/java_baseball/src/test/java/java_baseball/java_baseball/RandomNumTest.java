package java_baseball.java_baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class RandomNumTest {
    @Test
    @DisplayName("랜덤 리스트 사이즈 테스트")
    public void randomSizeTest(){
        Computer computer = new Computer();

        computer.generateRandomNum();
        List<Integer> randomNumList = computer.getRandomNumList();

        Assertions.assertThat(randomNumList.size()).isEqualTo(Constant.LIST_SIZE);
    }
    @Test
    @DisplayName("랜덤 리스트의 중복 값 유무 테스트")
    public void randomDuplicateTest(){
        Computer computer = new Computer();

        computer.generateRandomNum();
        HashSet<Integer> set = new HashSet<>(computer.getRandomNumList());
        Assertions.assertThat(set.size()).isEqualTo(Constant.LIST_SIZE);
    }
}