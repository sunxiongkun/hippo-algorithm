package com.sxk.lc.str;

public class StringOperation {

  public static void main(String[] args) {
    String source = "honesty";
    String target = "sty";
    System.out.println(strStr(source, target));

    System.out.println((int) 'a');
    System.out.println((int) 'A');
    System.out.println(source.hashCode());
    System.out.println(hashCode(source.toCharArray(), Integer.MAX_VALUE));

  }

  public static int strStr(String source, String target) {

    for (int i = 0; i < source.length() - target.length() + 1; i++) {
      if (source.charAt(i) == target.charAt(0)) {
        int j = 0;
        for (; j < target.length(); j++) {
          if (source.charAt(i + j) != target.charAt(j)) {
            break;
          }
        }
        if (j == target.length()) {
          return i;
        }
      }
    }
    return -1;

  }

  public static int hashCode(char[] key, int HASH_SIZE) {
    long ans = 0;
    for (int i = 0; i < key.length; i++) {
      ans = (ans * 31 + (int) key[i]);
    }
    return (int) ans;
  }

}
