package String_;

/**
 * @ClassName 翻转字符串里的单词
 * @Description
 * @Author Four5prings
 * @Date 2022/5/9 23:00
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        /**
         * 第一种思路是 创建一个arraylist 存储的是char数组，
         * 循环遍历s ，双指针，找到空格后截取，如何left = right ， right++；继续遍历
         * 但是这里面有两个问题待解决
         *  1. 如何处理空格
         *  2. 如何截取出每个单词
         *  遍历结束后，将arraylist 反转即可
         */

        /** carl 思路
         * 另一种思路
         *  先字符串全部反转
         *  然后再将单词反转
         */
        String trim = s.trim();
        char[] c = trim.toCharArray();
        getReverse(c, 0, c.length - 1);

        int left = 0;
        for (int right = 0; right < c.length; right++) {
            if (c[right] == ' ') {
                getReverse(c, left, right - 1);
                left = right + 1;
            } else if (right == c.length - 1) {
                getReverse(c, left, right);
            }
        }
        return new String(c);

    }

    public void getReverse(char[] c, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
    }
    //============================================================================================
    /** carl哥代码
     * 思路：
     *	①反转字符串  "the sky is blue " => " eulb si yks eht"
     *	②遍历 " eulb si yks eht"，每次先对某个单词进行反转再移位
     *	   这里以第一个单词进行为演示：" eulb si yks eht" ==反转=> " blue si yks eht" ==移位=> "blue si yks eht"
     */
    public String reverseWords2(String s) {
        //步骤1：字符串整体反转（此时其中的单词也都反转了）
        char[] initialArr = s.toCharArray();
        reverse(initialArr, 0, s.length() - 1);
        int k = 0;
        for (int i = 0; i < initialArr.length; i++) {
            if (initialArr[i] == ' ') {
                continue;
            }
            int tempCur = i;
            while (i < initialArr.length && initialArr[i] != ' ') {
                i++;
            }
            for (int j = tempCur; j < i; j++) {
                if (j == tempCur) { //步骤二：二次反转
                    reverse(initialArr, tempCur, i - 1);//对指定范围字符串进行反转，不反转从后往前遍历一个个填充有问题
                }
                //步骤三：移动操作
                initialArr[k++] = initialArr[j];
                if (j == i - 1) { //遍历结束
                    //避免越界情况，例如=> "asdasd df f"，不加判断最后就会数组越界
                    if (k < initialArr.length) {
                        initialArr[k++] = ' ';
                    }
                }
            }
        }
        if (k == 0) {
            return "";
        } else {
            //参数三：以防出现如"asdasd df f"=>"f df asdasd"正好凑满不需要省略空格情况
            return new String(initialArr, 0, (k == initialArr.length) && (initialArr[k - 1] != ' ') ? k : k - 1);
        }
    }

    public void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }
}
