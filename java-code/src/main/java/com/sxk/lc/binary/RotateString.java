package com.sxk.lc.binary;

/**
 * 字符串指定位置反转
 */
public class RotateString {

  public static void main(String[] args) {
    String str = "honesty";
    char[] array = str.toCharArray();
    System.out.println(array);
    rotateStringAtOffset(array, 3);
    System.out.println(array);

  }

  /**
   * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
   */
  public static void rotateStringAtOffset(char[] array, int offset) {
    int range = array.length - 1;
    offset = offset % array.length;
    for (int i = 0; i < range; i++) {
      rotateString(array, 0, offset - 1);
      rotateString(array, offset, range);
      rotateString(array, 0, range);
    }

  }

  public static void rotateString(char[] array, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }

  }

}
