package three;

import java.util.Arrays;

/** @author yinzhe 二分查找 */
public class Code01_BSExist {
  public static void main(String[] args) {
    int testTime = 5000000;
    int maxSIze = 10;
    int maxValue = 100;
    boolean success = true;
    for (int i = 0; i < testTime; i++) {
      int[] arr = generateRandomArray(maxSIze, maxValue);
      Arrays.sort(arr);
      int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
      if (test(arr, value) != find(arr, value)) {
        System.out.println("出错了！");
        success = false;
        break;
      }
    }
    System.out.println(success ? "nice!" : "fucking fuck!");
  }

  public static int[] generateRandomArray(int maxSize, int maxValue) {
    int[] arr = new int[(int) (Math.random() * maxSize + 1)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
    }
    return arr;
  }

  public static boolean test(int[] sortedArr, int num) {
    for (int i : sortedArr) {
      if (i == num) {
        return true;
      }
    }
    return false;
  }
  // arr保证有序
  private static boolean find(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    int l = 0;
    int r = arr.length - 1;
    while (l <= r) {// while (l < r) { 错误
      int mid = (l + r) / 2;
      if ((arr[mid] == num)) {
        return true;
      } else if (arr[mid] < num) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;
  }
}
