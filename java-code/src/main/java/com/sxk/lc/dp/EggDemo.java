package com.sxk.lc.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 * @date 2021/3/21 1:12 下午
 */
public class EggDemo {

  public static void main(String[] args) {

    System.out.println(new EggDemo().dpEgg(3, 14));
  }

  Map<String, Integer> map = new HashMap<>();
  int res = Integer.MAX_VALUE;

  public int dpEgg(int k, int n) {
    final String key = k + "_" + n;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    if (k == 1) {
      return n;
    }
    if (n == 0) {
      return 0;
    }
    for (int i = 1; i <= n; i++) {
      final int temp = Math.max(dpEgg(k - 1, i - 1), dpEgg(k, n - 1)) + 1;
      res = Math.min(res, temp);
      map.put(key, res);
    }
    return res;
  }
}
