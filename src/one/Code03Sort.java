package one;

import java.util.Objects;

/**
 * @author Sol yin
 * @date 2021-09-08 21:49
 * @apiNote
 */
public class Code03Sort {
  public static void main(String[] args) {
    int[] arr = {3, 1, 4, 14, 5, 18, 6, 5, 9, 77, 4, 6, 3};
    arr = null;
    arr = new int[0];
    printArr(arr);
    // selectSort(arr);
    //    bubbleSort(arr);
    insertSort(arr);
    printArr(arr);
  }

  public static void printArr(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void insertSort(int[] arr) {
    if (Objects.isNull(arr)) {
      return;
    }
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      int newNum = i;
      while (newNum - 1 >= 0 && arr[newNum] < arr[newNum - 1]) {
        swap(arr, newNum, newNum - 1);
        newNum--;
      }
    }
  }

  /**
   * 冒泡排序
   *
   * @param arr 被排序的数组
   */
  public static void bubbleSort(int[] arr) {
    if (Objects.isNull(arr)) {
      return;
    }
    int length = arr.length;
    for (int i = length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }
  /**
   * 选择排序,升序
   *
   * @param arr 需要排序的数组
   */
  public static void selectSort(int[] arr) {
    if (Objects.isNull(arr)) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int min = arr[i];
        if (arr[j] < arr[i]) {
          swap(arr, i, j);
        }
      }
    }
  }

  /**
   * //交换数组中i和j的位置
   *
   * @param arr 数组
   * @param i 索引i
   * @param j 索引j
   */
  private static void swap(int[] arr, int i, int j) {
    if (i < 0 || j < 0) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
