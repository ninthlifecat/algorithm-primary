package one;

/**
 * @author Sol yin
 * @date 2021-09-08 19:44
 * @apiNote 求1-n每个数的阶乘的和
 */
public class Code02SumOfFactorial {
  public static void main(String[] args) {
    System.out.println(f1(10));
    System.out.println(f2(10));
  }

  public static long f1(int num) {
    int sum = 0;
    for (int i = 1; i <= num; i++) {
      sum += factorial(i);
    }
    return sum;
  }

  public static long f2(int num) {
    long product = 1;
    long sum =0;
    long mid=1;
    for (int i = 1; i <= num ; i++) {
      mid=mid*i;
      sum+=mid;
    }
    return sum;
  }

  public static long factorial(int num) {
    long sum = 1;
    for (int i = 1; i <= num; i++) {
      sum *= i;
    }
    return sum;
  }
}
