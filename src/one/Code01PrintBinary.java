package one;

/**
 * @author Sol yin
 * @date 2021-09-08 19:37
 * @apiNote
 */
public class Code01PrintBinary {
  public static void main(String[] args) {
    printBinary(-10);
    System.out.println(Integer.toBinaryString(-10));
  }

  public static void printBinary(int num) {
    for (int i = 31; i >=0; i--) {
       String a= (num & (1<<i))==0?"0":"1";
      System.out.print(a);
    }
    System.out.println();
  }

}
