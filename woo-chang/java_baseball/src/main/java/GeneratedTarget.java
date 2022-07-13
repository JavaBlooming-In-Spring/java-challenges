import java.util.Random;

public class GeneratedTarget {

  private final String target;
  private final Integer[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

  public GeneratedTarget() {
    this.target = generateRandomTarget();
  }

  private String generateRandomTarget() {
    shuffleNums();
    return nums[0] + String.valueOf(nums[1]) + nums[2];
  }

  private void shuffleNums() {
    Random random = new Random();
    for(int i = 0; i < nums.length; i++) {
      int pos = random.nextInt(9);
      int temp = nums[pos];
      nums[pos] = nums[i];
      nums[i] = temp;
    }
  }

  public String getTarget() {
    return this.target;
  }

}
