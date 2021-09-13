package three;

import java.util.Arrays;

import static three.Code02_NearLeftBSExit.generatorArray;

/**
 * @author Sol yin
 * @date 2021-09-13 21:28
 * @apiNote 在arr上,<=num的最右位置
 */
public class Code03_BSNearRight {
  public static void main(String[] args) {
    int maxLen = 20;
    int maxValue = 100000;
    int testTime = 10000000;
    boolean success=true;
    for (int i = 0; i < testTime; i++) {
      int[] arr = generatorArray(maxLen, maxValue);
      Arrays.sort(arr);
      int num = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
      int indexBS = mostRightNoMoreThanRightIndex(arr, num);
      int indexLoop = testMostRightNoMoreThanRightIndex(arr, num);
      if (indexBS != indexLoop) {
        System.out.println("出错了");
        System.out.println(Arrays.toString(arr));
        System.out.println(num);
        System.out.println(indexBS);
        System.out.println(indexLoop);
        success = false;
        break;
      }
    }
    System.out.println(success?"nice!":"fucking fuck!");
  }

  public static int testMostRightNoMoreThanRightIndex(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    int ans = -1;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] <= num) {
        ans = i;
        break;
      }
    }
    return ans;
  }

  public static int mostRightNoMoreThanRightIndex(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    int ans = -1;
    int l = 0;
    int r = arr.length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] <= num) {
        l = mid + 1;
        ans = mid;
      } else {
        r = mid - 1;
      }
    }
    return ans;
  }
}
