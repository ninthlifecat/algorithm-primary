package two;

import java.util.Arrays;

/** @author yinzhe */
public class Code02RandToRand {
  public static void main(String[] args) {
    int testTime = 100000;
    int count = 10;
    int[] arr = new int[count];
    for (int i = 0; i < testTime; i++) {
      // int num = equalProbably1To5();
      // int num = equalProbably0To1();
      int num = equalProbably1To6();
      arr[num]++;
    }
    System.out.println(Arrays.toString(arr));
  }

  public static int equalProbably1To6() {
    int ans = 7;
    do {
      // int num = equalProbably0To1();
      //      ans = num + (num << 1) + (num << 2);
      ans = equalProbably0To1() + (equalProbably0To1() << 1) + (equalProbably0To1() << 2);
    } while (ans == 7);
    return ans;
  }

  /**
   * 等概率得到1-5
   *
   * @return 1-5
   */
  public static int equalProbably1To5() {
    return (int) (Math.random() * 5 + 1);
  }

  public static int equalProbably0To1() {
    int ans;
    do {
      ans = equalProbably1To5();
    } while (ans == 3);
    return ans > 3 ? 0 : 1;
  }
}
