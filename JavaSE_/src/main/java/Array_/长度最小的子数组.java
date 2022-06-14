package Array_;

/**
 * @ClassName 长度最小的子数组
 * @Description
 * @Author Four5prings
 * @Date 2022/5/1 9:40
 * @Version 1.0
 */
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
// 并返回其长度。如果不存在符合条件的子数组，返回 0。//示例：
//输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组
public class 长度最小的子数组 {
    /**
     *  point ： 解题过程中，无法处理size的最小值问题，开始声明的result=0；造成代码中无法使用判断将
     *  result的范围不断缩小，因为result的初始值就设置为0；
     *  答案是直接将 result 声明为最大值，再不断缩小其范围
     * @param nums
     * @param target
     * @return
     */
    public int serachMinArray(int[] nums, int target) {
        //声明子数组的求和
        int sum = 0;
        //声明慢指针
        int slowindex = 0;
        int size = 0;//声明子数组长度
        int result= Integer.MAX_VALUE;
        for (int fastindex = 0; fastindex < nums.length; fastindex++) {
            sum += nums[fastindex];
            if (sum >= target) {
                size = fastindex - slowindex + 1;
                result = Math.min(result, size);
                //这一部分相当于优化，当满足这个条件是，必定是最小字符串长度，跳出循环
                if (slowindex == fastindex) {
                    result = 1;
                    break;
                }
                sum -= (nums[slowindex] + nums[fastindex]);
                slowindex++;
                fastindex--;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;//滑动窗口的起始指针
        int sum = 0;
        int result = Integer.MAX_VALUE;//声明一个最大值，
        /**
         * 声明滑动窗口的右指针，且内部嵌套一个while循环，这个时间复杂度不会改变
         * 要看元素被操作的次数
         */
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];//移动左指针再判断，不断缩小窗口范围
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
