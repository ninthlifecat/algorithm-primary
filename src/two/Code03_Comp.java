package two;

import java.util.Arrays;

public class Code03_Comp {
  public static void main(String[] args) {
    int maxLen=10;
    int maxValue=Integer.MAX_VALUE;
    int testTime=10000000;
    for (int i = 0; i < testTime; i++) {
      int[] arr = lenRandomValueRandom(maxLen, maxValue);
      int[] copyArr = copyArr(arr);
      selectionSort(arr);
      if (!isSorted(arr)) {
        System.out.println(Arrays.toString(arr));
        System.out.println("选择排序错了");
        break;
      }
    }
  }

  //数组是否有序
  public static boolean isSorted(int[] arr){
    if (arr == null || arr.length < 2) {
      return true;
    }
    int max=arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (max > arr[i]) {
        return false;
      }
      max=Math.max(max,arr[i]);
    }
    return true;
  }
  public static int[] copyArr(int[] arr) {
    int[] ints = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      ints[i] = arr[i];
    }
    return ints;
  }
  // 返回一个数组arr，arr长度[0,maxLen-1],arr中每个值[0,maxValue-1]
  public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
    int len = (int) (Math.random() * maxLen);
    int[] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * maxValue);
    }
    return arr;
  }

  public static void selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int length = arr.length;
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
