package String_;

/**
 * @ClassName 反转字符串
 * @Description
 * @Author Four5prings
 * @Date 2022/5/9 21:37
 * @Version 1.0
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right > left) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            right--;
            left++;
        }

    }

}
