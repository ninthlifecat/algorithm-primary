package two;

import java.util.Arrays;

/** @author yinzhe */
public class Code02RandToRand {
  public static void main(String[] args) {
    /*int testTime = 100000;
        int count = 10;
        int[] arr = new int[count];
        for (int i = 0; i < testTime; i++) {
          // int num = equalProbably1To5();
          // int num = equalProbably0To1();
    //      int num = equalProbably0To6();
          RandomBox randomBox = new RandomBox(10, 18);
          //      int num=rand01(randomBox);
          int num = random(randomBox, 2, 7);
          arr[num]++;
        }
        System.out.println(Arrays.toString(arr));*/

    System.out.println("测试开始");
    int testTimes=10000000;
    int count=0;
    for (int i = 0; i < testTimes; i++) {
      if (Math.random() < 0.75) {
        count++;
      }
    }
    System.out.println(count*1.0/testTimes);
    System.out.println("============");
    //[0,1)->[0,8)
    count=0;
    for (int i = 0; i < testTimes; i++) {
      if (Math.random() * 8 < 5) {
        count++;
      }
    }
    System.out.println(count*1.0/testTimes);
    System.out.println(5.0/8);

    int k=4;
    //[0,k)->[0,8]
    int[] counts=new int[k];
    for (int i = 0; i <testTimes; i++) {
      int ans=(int)(Math.random()*k);  //[0,k)
      counts[ans]++;
    }

    for (int i = 0; i < k; i++) {
      System.out.println(i+"这个数出现了"+counts[i]+"次");
    }
    System.out.println("===========");
    count=0;
    double x=0.17;
    for (int i = 0; i < testTimes; i++) {
      if (x2xPower() < x) {
        count++;
      }
    }
    System.out.println(count*1.0/testTimes);
    System.out.println(Math.pow(x,2));
    System.out.println(1.0-Math.pow(1.0-x,2));
  }
  // 返回[0,1)的一个小数
  // 任意的x，x属于[0,1),[0,x)范围上的数出现概率由原来的x调整成x平方
  public static double x2xPower() {
    return Math.max(Math.random(), Math.random());
  }

  // 给你一个RandomBox，这是唯一一个能借助的随机机制
  // 等概率返回from～to范围上任何一个数字
  // 要求from<=to
  public static int random(RandomBox randomBox, int from, int to) {
    if (from == to) {
      return from;
    }
    //0~9
    //0~6
    //0~range
    int range=to-from;
    //求0～range需要几个二进制
    int num=1;
    while (1 << num -1< range) {
      num++;
    }
    //我们一共需要num位
    //最终的累加和，首先
    int ans=0;
    do {
      ans = 0;
      for (int i = 0; i < num; i++) {
        ans |= rand01(randomBox) << i;
      }
    } while (ans > range);
    return ans+from;
  }

  //利用randomBox，如何等概率获取0和1；
  public static int rand01(RandomBox randomBox){
    int max = randomBox.max;
    int min = randomBox.min;
    int random = randomBox.random();
    //random的范围是[min,max]
    int size=max-min+1;
//    double mid=min+(size-1)*1.0/2;
    int mid=size/2;
    //找到中间数
    //如果max-min是偶数  中间数是mid=min+size/2
    //如果max-min是奇数  中间数是mid=min+size/2+1
    //判断size是否是奇数
    boolean isOdd= (size&1)==1;
    int ans=0;
    //奇数的话，等于中间值就重做
    do{
      ans=randomBox.random()-min;
    }while (isOdd&&(ans==mid));
    return ans>mid?0:1;

  }
  public static class RandomBox{
    private final int min;
    private final int max;

    public RandomBox(int min, int max) {
      this.min = min;
      this.max = max;
    }
    public int random(){
      return min+(int)((max-min+1)*Math.random());
    }

    public int min() {
      return min;
    }
    public int max(){
      return max;
    }
  }
  public static int equalProbably1To7() {
    return equalProbably0To6()+1;
  }

  public static int equalProbably0To6() {
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
