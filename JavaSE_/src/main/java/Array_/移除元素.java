package Array_;

/**
 * @ClassName 移除元素
 * @Description
 * @Author Four5prings
 * @Date 2022/4/30 19:27
 * @Version 1.0
 */
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
public class 移除元素 {
    /**
     * @param nums
     * @param val
     * @return 时间复杂度：O(n^2) 使用两个for循环，外层遍历数组是否有val，如果存在，内存循环
     * 让所有数组下标往前移
     */
    public int removeValue(int[] nums, int val) {
        //声明数组长度，当存在匹配的值时，size-1
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (val == nums[i]) {// 发现需要移除的元素，就将数组集体向前移动一位
                size--;// 此时数组的大小-1
                for (int j = i; j < size; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;// 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
            }
        }
        return size;
    }

    /**
     * @param nums
     * @param val
     * @return 双指针 旨在让匹配val的值与数组最后的数值互换，然后i--，j--并再次匹配
     * * 注意 判断条件 < 还是 <= ！！！ 一定要注意边界条件
     */
    public int removeValue2(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i--;
                j--;
            }
        }
        return j + 1;
    }

    /**
     * @param nums
     * @param val
     * @return 快慢指针，用一个指针去扫描数组，看是否匹配val，如果不匹配，则将该数值给慢指针，
     * 如果匹配，则不赋值
     */
    public int removeValue3(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
