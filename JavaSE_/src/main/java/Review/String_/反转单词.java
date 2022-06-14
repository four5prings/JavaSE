package Review.String_;

/**
 * @ClassName 反转单词
 * @Description
 * @Author Four5prings
 * @Date 2022/5/10 21:38
 * @Version 1.0
 */

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class 反转单词 {
    public String reverseWords(String s) {
        char[] target = s.toCharArray();
        //先将字符串反转
        getReverse(target, 0, target.length - 1);
        int k = 0;
        //再使用双指针法 将每个单词反转过来即可
        for (int i = 0; i < target.length; i++) {
            //跳过开头的空格
            if (target[i] == ' ') {
                continue;
            }
            //此处就是单词的开头
            int tempCur = i;
            //加速指针移动，到下一个空格处 也就是单词的末尾 注意索引越界
            while (i < target.length && target[i] != ' ') {
                i++;
            }
            /**
             * 此时双指针已经指向单词的首尾，直接反转
             * 然后进行数据的移动，将反转后的数组元素依次赋值
             */
            getReverse(target, tempCur, i - 1);
            for (int j = tempCur; j < i; j++) {
                target[k++] = target[j];
                //遍历结束时添加空格
                if (j == i - 1) {
                    //防止越界
                    if (k < target.length) {
                        target[k++] = ' ';
                    }
                }
            }

        }
        if (k == 0)
            return "";
        else
            return new String(target,0,(k == target.length) && (target[k - 1] != ' ') ? k : k - 1);
    }

    public void getReverse(char[] a, int left, int right) {
        for (; left < right; left++, right--) {
            char tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
    }
}
