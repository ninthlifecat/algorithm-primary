package demo;

import com.sun.org.apache.bcel.internal.generic.IFNE;

public class negativeDouble2Int {
  public static void main(String[] args) {
    double d=-9.9;

    int i=(int)d;
    System.out.println(i);
    for (int j = 0; j <30 ; j++) {
      int r=-(int)( Math.random()*10);
      System.out.print(r+" ");
    }

  }
}
