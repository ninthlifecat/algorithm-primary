package two;

/** @author yinzhe */
public class Code02RandToRand {
  public static void main(String[] args) {
    int testTime = 100000;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int countWrong = 0;
    for (int i = 0; i < testTime; i++) {
      int num = equalProbably1To5();

      if (num == 1) {
        count1++;
      } else if (num == 2) {
        count2++;
      } else if (num == 3) {
        count3++;
      } else if (num == 4) {
        count4++;
      } else if (num == 5) {
        count5++;
      } else {
        countWrong++;
      }
    }
    System.out.println(count1);
    System.out.println(count2);
    System.out.println(count3);
    System.out.println(count4);
    System.out.println(count5);
    System.out.println(countWrong);
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
    return ans>3?0:1;
  }
}
