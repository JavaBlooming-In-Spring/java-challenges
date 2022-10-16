package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

  @Test
  @DisplayName("1등 당첨")
  public void firstPlace() {
    //given
    int matchCount = 6;
    boolean bonusMatch = false;

    //when
    Rank result = Rank.of(matchCount, bonusMatch);

    //then
    assertThat(result).isEqualTo(Rank.FIRST);
  }

  @Test
  @DisplayName("2등 당첨")
  public void secondPlace() {
    //given
    int matchCount = 5;
    boolean bonusMatch = true;

    //when
    Rank result = Rank.of(matchCount, bonusMatch);

    //then
    assertThat(result).isEqualTo(Rank.SECOND);
  }

  @Test
  @DisplayName("3등 당첨")
  public void thirdPlace() {
    //given
    int matchCount = 5;
    boolean bonusMatch = false;

    //when
    Rank result = Rank.of(matchCount, bonusMatch);

    //then
    assertThat(result).isEqualTo(Rank.THIRD);
  }

  @Test
  @DisplayName("4등 당첨")
  public void fourthPlace() {
    //given
    int matchCount = 4;
    boolean bonusMatch = false;

    //when
    Rank result = Rank.of(matchCount, bonusMatch);

    //then
    assertThat(result).isEqualTo(Rank.FOURTH);
  }

  @Test
  @DisplayName("5등 당첨")
  public void fifthPlace() {
    //given
    int matchCount = 3;
    boolean bonusMatch = false;

    //when
    Rank result = Rank.of(matchCount, bonusMatch);

    //then
    assertThat(result).isEqualTo(Rank.FIFTH);
  }

  @Test
  @DisplayName("꽝")
  public void nonePlace() {
    //given
    int matchCount = 2;
    boolean bonusMatch = true;

    //when
    Rank result = Rank.of(matchCount, bonusMatch);

    //then
    assertThat(result).isEqualTo(Rank.NONE);
  }

}
