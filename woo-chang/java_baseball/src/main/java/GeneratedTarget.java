import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratedTarget {

  private final List<Integer> target = new ArrayList<Integer>();
  private final int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

  public GeneratedTarget() {
    shuffleNums();
    for(int i = 0; i < GameUtils.TARGET_LENGTH; i++) {
      target.add(nums[i]);
    }
  }

  public void generatedNewTarget() {
    shuffleNums();
    for(int i = 0; i < GameUtils.TARGET_LENGTH; i++) {
      target.set(i, nums[i]);
    }
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

  public List<Integer> getTarget() {
    return this.target;
  }

}
