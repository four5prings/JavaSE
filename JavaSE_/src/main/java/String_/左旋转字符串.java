package String_;

/**
 * @ClassName 左旋转字符串
 * @Description
 * @Author Four5prings
 * @Date 2022/5/10 22:19
 * @Version 1.0
 */

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        /**
         * 使用反转字符串的方式，即在原来的数据上进行操作
         */
        // abcde2 =>  cdeab
        // 分别反转 前n个 和剩余的字符串  bacde  => baedc  反转全部 => cdeab
        char[] target = s.toCharArray();
        reverse(target, 0, n - 1);
        reverse(target, n, s.length() - 1);
        reverse(target, 0, s.length() - 1);

        return new String(target);
    }

    public void reverse(char[] a, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    public String reverseLeftWords1(String s, int n) {
        /**
         * 不太好的解法，用一个数组来存储数据
         */
        char[] ori = s.toCharArray();
        char[] result = new char[s.length()];
        int index = 0;

        for (int i = n; i < ori.length; i++) {
            result[index++] = ori[i];
        }
        for (int i = 0; i < n; i++) {
            result[index++] = ori[i];
        }
        return new String(result);
    }
}
