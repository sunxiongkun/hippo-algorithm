package com.sxk.lc.bit;

/**
 * @author sxk
 */
public class BitMap {

  public static void main(String[] args) {
    bitMap();

  }

  public static void bitMap() {
    //代表10*4*8=320bit
    int[] arr = new int[10];
    /**
     * 0 0～32位
     * 1 32～64位
     * 2 64～96位
     */
    //178位bit的值
    int i = 178;
    int numIndex = i / 32;
    int bitIndex = i % 32;
    //178位的值
    //将178位设置为1
    arr[numIndex] = arr[numIndex] | (1 << bitIndex);
    int s = ((arr[numIndex] >> bitIndex) & 1);
    System.out.println(s);
    //将178位设置为0
    arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));
    s = ((arr[numIndex] >> bitIndex) & 1);
    System.out.println(s);
  }

}
