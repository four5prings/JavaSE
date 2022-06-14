package HashTable_;

/**
 * @ClassName isAnagram
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 13:51
 * @Version 1.0
 */

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 */
public class isAnagram {
    /**
     *
     * @param s
     * @param t
     * @return 遍历数据，将数据进行 标记 ，然后对标记进行处理
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || "".equals(s) || "".equals(t) || t.equals(s)) {
            return false;
        }
        int[] record = new int[26];
        //因为字符串 总共26位 将字符串转为char数组，每一个元素 - ‘a’ 之后转换为int就是0-25
        //使用元素 - ‘a’ 得到的 0 -25 用来当作 记录数组的下表， 出现就+1
        // 这样就变相的记录的每个元素出现的次数
        char[] chars01 = s.toCharArray();
        for (char a : chars01) {
            record[a - 'a'] += 1;
        }
        //同理 ，将 t出现的字符 次数 依次 减去
        char[] chars02 = t.toCharArray();
        for (char b : chars02) {
            record[b - 'a'] -= 1;
        }
        int count = 0;
        for (int i : record) {
            if (i != 0)
                count++;
        }
        return count == 0;
    }

    /**
     *
     * @param s
     * @param t
     * @return 另一种思路 对数据进行全排序 ，然后再遍历数组，进行逐个比较
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i])
                return false;
        }
        return true;
    }
}
