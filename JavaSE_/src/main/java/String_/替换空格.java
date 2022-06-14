package String_;

/**
 * @ClassName 替换空格
 * @Description
 * @Author Four5prings
 * @Date 2022/5/9 22:45
 * @Version 1.0
 */

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (' ' == c) {
                count += 2;
            }
        }
        char[] tmpArray = new char[s.length() + count];
        int left = s.length() - 1;
        int right = tmpArray.length - 1;

        while (left >= 0) {
            if (chars[left] == ' ') {
                tmpArray[right--] = '0';
                tmpArray[right--] = '2';
                tmpArray[right] = '%';
            } else {
                tmpArray[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(tmpArray);
    }
}
