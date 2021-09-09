package one;

import java.util.Arrays;

public class Code04SelectionSort {
  public static void insertSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int i = 1; i < arr.length; i++) {
      int end=i;
      while (end - 1 >= 0 && arr[end] < arr[end - 1] ) {
        swap(arr,end,end-1);
        end--;
      }
    }
  }

  public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int end = arr.length - 1; end > 0; end--) {
      for (int i = 0; i < end; i++) {
        if (arr[i] > arr[i + 1]) {
          swap(arr, i, i + 1);
        }
      }
    }
  }

  public static void selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
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

  public static void comparator(int[] arr) {
    Arrays.sort(arr);
  }

  public static int[] generatorRandomArray(int maxSize, int maxValue) {
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
    for (int i = 0; i < arr.length; i++) {
      // [-?,+?]
      arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
    }
    return arr;
  }

  public static int[] copyArray(int[] arr) {
    if (arr == null) {
      return null;
    }
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  public static boolean isEqual(int[] arr1, int[] arr2) {
    boolean b1 = arr1 == null;
    boolean b2 = arr2 == null;
    if (b1 ^ b2) {
      return false;
    }
    if (b1 && b2) {
      return true;
    }
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void printArray(int[] arr) {
    if (arr == null) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int testTime = 500000;
    int maxSize = 100;
    int maxValue = 100;
    boolean success = true;
    for (int i = 0; i < testTime; i++) {
      int[] arr1 = generatorRandomArray(maxSize, maxValue);
      int[] arr2 = copyArray(arr1);
//      selectionSort(arr1);
//      bubbleSort(arr1);
      insertSort(arr1);
      comparator(arr2);
      if (!isEqual(arr1, arr2)) {
        success = false;
        printArray(arr1);
        printArray(arr2);
      }
    }
    System.out.println(success ? "Nice!" : "Fucking fucked!");
  }
}
