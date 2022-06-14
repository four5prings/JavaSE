package String_;

/**
 * @ClassName 反转字符串II
 * @Description
 * @Author Four5prings
 * @Date 2022/5/9 21:41
 * @Version 1.0
 */

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class 反转字符串II {
    public String reverseStr(String s, int k) {
        /**
         * 首先判断字符串个数
         * 分三种情况，长度 与 k的值。
         */
        int size = s.length();
        char[] chars = s.toCharArray();

        /**
         * 2k 为一个间隔进行反转
         */
        for (int i = 0; i < size; i += 2 * k) {
            if (i + k <= size) {
                getReverse(chars, i, i + k - 1);
                continue;
            }
            //这样剩余的都会少于k个，全部反转
            getReverse(chars, i, size - 1);
        }

        return new String(chars);
    }

    public void getReverse(char[] s, int left, int right) {
        while (right > left) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            right--;
            left++;
        }
    }

    //=========================================
    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(ch, i, ch.length - 1);
        }
        return new String(ch);

    }

    // 定义翻转函数
    public void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }
}
