package com.sxk.lc.str;

/**
 * @author sxk
 */
public class KMP {

  public static int getIndexOf(String s1, String s2) {
    if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
      return -1;
    }
    char[] str1 = s1.toCharArray();
    char[] str2 = s2.toCharArray();
    int x = 0;
    int y = 0;
    // O(M) m <= n
    int[] next = getNextArray(str2);
    // O(N)
    while (x < str1.length && y < str2.length) {
      if (str1[x] == str2[y]) {
        x++;
        y++;
        // y == 0 str2已经无法向前跳了
      } else if (y == 0) {
        x++;
      } else {
        y = next[y];
      }
    }
    return y == str2.length ? x - y : -1;
  }

  /**
   * abbstabe c abbstab i-1 i
   * 前缀和后缀的最长匹配长度
   *
   * @param str2
   * @return
   */

  public static int[] getNextArray(char[] str2) {
    if (str2.length == 1) {
      return new int[]{-1};
    }
    int[] next = new int[str2.length];
    next[0] = -1;
    next[1] = 0;
    // 目前在哪个位置上求next数组的值
    int i = 2;
    // 当前是哪个位置的值再和i-1位置的字符比较
    int cn = 0;
    while (i < next.length) {
      // 配成功的时候
      if (str2[i - 1] == str2[cn]) {
        /**
         * next[i]=cn+1;
         * cn=cn+1;
         * i=i+1;
         */
        next[i++] = ++cn;
      } else if (cn > 0) {
        cn = next[cn];
      } else {
        next[i++] = 0;
      }
    }
    return next;
  }

  // for test
  public static String getRandomString(int possibilities, int size) {
    char[] ans = new char[(int) (Math.random() * size) + 1];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
    }
    return String.valueOf(ans);
  }

  public static void main(String[] args) {
    int possibilities = 5;
    int strSize = 20;
    int matchSize = 5;
    int testTimes = 10000;
    System.out.println("test begin");
    for (int i = 0; i < testTimes; i++) {
      String str = getRandomString(possibilities, strSize);
      String match = getRandomString(possibilities, matchSize);
      if (getIndexOf(str, match) != str.indexOf(match)) {
        System.out.println("Oops!");
      }
    }
    System.out.println("test finish");
  }
}
