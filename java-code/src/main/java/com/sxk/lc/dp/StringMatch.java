package com.sxk.lc.dp;

/**
 * @author sxk
 */
public class StringMatch {


  public static void main(String[] args) {
    String s = "abbbbcd";
    String p = "cab*b*cd";

    System.out.println(isMatch(s, p));
  }

  /***
   * https://leetcode-cn.com/problems/regular-expression-matching/
   * '.' 匹配任意单个字符
   * '*' 匹配零个或多个前面的那一个元素
   * s = "aab" p = "c*a*b"  true
   * s = "ab" p = ".*" true
   * s 可能为空，且只包含从 a-z 的小写字母。
   * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
   * 保证每次出现字符 * 时，前面都匹配到有效的字符
   *
   * @param s
   * @param p
   * @return
   */
  public static boolean isMatch(String s, String p) {
    if (s == null || s.length() == 0) {
      return false;
    }
    if (p == null || p.length() == 0) {
      return false;
    }
    return isMatchProcess(s.toCharArray(), 0, p.toCharArray(), 0);
  }

  /**
   * 返回si...s.length 之后和pi...p.length是否匹配
   *
   * @param s
   * @param sidx
   * @param p
   * @param pidx
   * @return
   */
  public static boolean isMatchProcess(char[] s, int sidx, char[] p, int pidx) {
    if (sidx >= s.length - 1) {
      return true;
    }
    if (pidx >= p.length - 1) {
      return sidx >= s.length - 1;
    }
    if (s[sidx] == p[pidx] || p[pidx] == '.') {
      if (pidx + 1 < p.length - 1 && p[pidx + 1] == '*') {
        return isMatchProcess(s, sidx, p, pidx + 2) || isMatchProcess(s, sidx + 1, p, pidx + 2)
            || isMatchProcess(s, sidx + 2, p, pidx + 2);
      } else {
        return isMatchProcess(s, sidx + 1, p, pidx + 1) || isMatchProcess(s, sidx, p, pidx + 1);
      }
    } else {
      //如果不等pidx向后移动
      return isMatchProcess(s, sidx, p, pidx + 1);
    }
  }

}
