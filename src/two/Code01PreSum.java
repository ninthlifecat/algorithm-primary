package two;

public class Code01PreSum {
  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 3, 6, 3, 2, 8};
    RangeSum1 rangeSum1 = new RangeSum1(arr);
    RangeSum2 rangeSum2 = new RangeSum2(arr);
    System.out.println(rangeSum1.rangeSUm(2, 7));
    System.out.println(rangeSum2.rangeSum(2,7));
  }

  public static class RangeSum1 {
    private int[] arr;

    public RangeSum1(int[] arr) {
      this.arr = arr;
    }

    public int rangeSUm(int l, int r) {
      int sum = 0;
      for (int i = l; i <= r; i++) {
        sum += arr[i];
      }
      return sum;
    }
  }


  public static class RangeSum2{
    private int[] preSum;

    public RangeSum2(int[] array) {
      int length = array.length;
      preSum = new int[length];
      preSum[0]=array[0];
      for (int i = 1; i < length; i++) {
        preSum[i]=preSum[i-1]+array[i];
      }
    }

    public int rangeSum(int l,int r){
      return l==0?preSum[r] :preSum[r]-preSum[l-1];
    }
  }
}
