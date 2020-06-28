package com.sxk.lc.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sxk
 * 创建日期：2020/4/23
 */
public class ArrayOperation {


  public static void main(String[] args) {
    arrayMerge();
    arrayFindMaxSubStr();
    arrayFindMaxSub();
  }


  public static void arrayFindMaxSub() {
    int[] nums = {2, 4, 7, 8, 8, 5, 9};
    int max = 0;
    int num = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        num++;
      } else {
        if (max < num) {
          max = num;
        }
        num = 1;
      }
    }
    System.out.println(Math.max(num, max));

  }

  public static void arrayFindMaxSubStr() {
    String[] array = {"AB", "ABC", "ACD", "ABCD"};
    Set<String> set = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[j].contains(array[i])) {
          set.add(array[j]);
        }
      }
    }
    String[] newArray = new String[array.length];
    int q = 0;
    for (String s : array) {
      if (!set.contains(s)) {
        newArray[q] = s;
        q++;
      }
    }
    System.out.println(Arrays.toString(newArray));

  }

  public static void arrayMerge() {
    int[] a1 = {1, 3, 5, 6};
    int[] a2 = {2, 4, 5, 8};
    int[] na = new int[a1.length + a2.length];
    int index1 = 0;
    int index2 = 0;
    int ni = 0;
    while (index1 < a1.length && index2 < a2.length) {
      if (a1[index1] < a2[index2]) {
        na[ni] = a1[index1];
        index1++;
      } else {
        na[ni] = a2[index2];
        index2++;
      }
      ni++;
    }
    while (index1 < a1.length) {
      na[ni] = a1[index1];
      index1++;
      ni++;
    }

    while (index2 < a2.length) {
      na[ni] = a2[index2];
      index2++;
      ni++;
    }
    System.out.println(Arrays.toString(na));
  }

}
