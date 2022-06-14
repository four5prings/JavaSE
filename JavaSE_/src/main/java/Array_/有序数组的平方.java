package Array_;

/**
 * @ClassName 有序数组的平方
 * @Description
 * @Author Four5prings
 * @Date 2022/4/30 20:12
 * @Version 1.0
 */
//给你一个按 非递减顺序 排序的整数数组 nums，
// 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
public class 有序数组的平方 {
    public int[] sourtedSquares(int[] nums) {
        //先遍历数组将数组平方，然后再排序
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        //冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    public int[] sortedSquares2(int[] nums){
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
