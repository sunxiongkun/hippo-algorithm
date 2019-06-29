package com.sxk.lc;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RomanNum {


  /**
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   *
   * @param str 罗马数字
   * @return 阿拉伯数字
   */

  public static int romanToInt(String str) {
    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);

    int ans = 0;
    for (int i = 0; i < str.length(); ) {
      if (i + 1 < str.length() && map.containsKey(str.substring(i, i + 2))) {
        ans += map.get(str.substring(i, i + 2));
        i += 2;
      } else {
        ans += map.get(str.substring(i, i + 1));
        i++;
      }
    }
    return ans;
  }


  public static String intToRoman(int num) {
    //用数组定义字典
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    //定义一个字符串
    StringBuilder res = new StringBuilder();

    for (int i = 0; i < values.length; i++) {
      int a = num / values[i];
      if (a == 0) {
        continue;
      }
      for (int j = a; j > 0; j--) {
        res.append(strs[i]);
      }
      num = num - (a * values[i]);
      if (num == 0) {
        break;
      }
    }
    return res.toString();

  }


  @Test
  public void testRomanToInt() {
    assert romanToInt("IV") == 4;
    assert romanToInt("V") == 5;
  }

  @Test
  public void testIntToRoman() {
    assertEquals(intToRoman(5), "V");
    assertEquals(intToRoman(4), "IV");
  }


}
