package com.sxk.lc.binary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 还原旋转排序数组
 */
public class BinaryRotateArray {

  static Integer[] rotateArray = {6, 7, 8, 9, 1, 2, 3, 4, 5};

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(rotateArray));
    System.out.println(list);
    recoverRotateArrayList(list);
    System.out.println(list);

    System.out.println("===========================");

    System.out.println(Arrays.toString(rotateArray));
    recoverRotateArray(rotateArray);
    System.out.println(Arrays.toString(rotateArray));

  }

  /**
   * recover-rotated-sorted-array（恢复旋转排序数组）
   * 【三步翻转法】是指：[4,5,1,2,3] → [5,4,1,2,3] → [5,4,3,2,1] → [1,2,3,4,5]
   *
   * 给定一个旋转排序数组，在原地恢复其排序。什么是旋转数组？比如，原始数组为[1,2,3,4],
   * 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2],[4,1,2,3]
   */

  public static void recoverRotateArrayList(ArrayList<Integer> list) {

    int range = list.size() - 1;
    for (int i = 0; i < range; i++) {
      if (list.get(i) > list.get(i + 1)) {
        reverseRotateArrayList(list, 0, i);
        reverseRotateArrayList(list, i + 1, range);
        reverseRotateArrayList(list, 0, range);
        break;
      }
    }
  }

  public static void reverseRotateArrayList(ArrayList<Integer> list, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      int temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
    }
  }


  public static void recoverRotateArray(Integer[] array) {

    int range = array.length - 1;
    for (int i = 0; i < range; i++) {
      if (array[i] > array[i + 1]) {
        reverseRotateArray(array, 0, i);
        reverseRotateArray(array, i + 1, range);
        reverseRotateArray(array, 0, range);
        break;
      }
    }
  }

  public static void reverseRotateArray(Integer[] array, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      Integer temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }


}
