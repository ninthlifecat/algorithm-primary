package three;

import java.util.Arrays;

/**
 * @author Sol yin
 * @date 2021-09-13 20:54
 * @apiNote arr有序,>=num最左
 */
public class Code02_NearLeftBSExit {
  public static void main(String[] args) {
    int testTime=1000000;
    int maxLen=20;
    int maxValue=100000;
    boolean success=true;
    for (int i = 0; i < testTime; i++) {
        int[] arr = generatorArray(maxLen, maxValue);
        int num=(int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        Arrays.sort(arr);
        int indexBS = mostLeftNoLessThanNumIndex(arr, num);
        int indexLoop = testMostLeftNoLessThanNumIndex(arr, num);
      if (indexBS != indexLoop) {
        System.out.println("出错了");
        System.out.println(Arrays.toString(arr));
        System.out.println(num);
        System.out.println(indexBS);
        System.out.println(indexLoop);
        success=false;
        break;
      }
    }
    System.out.println(success?"nice!":"fucking fuck!");
  }

  public static int[] generatorArray(int maxLen, int maxValue) {
    int[] arr = new int[(int) (Math.random() * (maxLen + 1))];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
    }
    return arr;
  }
  // test
  public static int testMostLeftNoLessThanNumIndex(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
        return -1;
    }
    int ans=-1;
    for (int i = 0; i < arr.length; i++) {
      /*if (arr[i] <= num) {
        ans = i;
      } else {
          break;
      }*/
      if (arr[i] >= num) {
        ans = i;
        break;
      }
    }
    return ans;
  }

  public static int mostLeftNoLessThanNumIndex(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    int l = 0;
    int r = arr.length - 1;
    int ans = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] >= num) {
        r = mid - 1;
        ans = mid;
      } else {
        l = mid + 1;
      }
    }
    return ans;
  }
}
