package Array_;

/**
 * @ClassName 搜索插入位置
 * @Description
 * @Author Four5prings
 * @Date 2022/4/30 15:47
 * @Version 1.0
 */
public class 搜索插入位置 {
    /**
     * @param nums   有序且不重复
     * @param target
     * @return 如果target在nums中则返回索引，没有则返回插入的位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     */
    public static int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (true) {
            mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            //进入此判断说明target不在此nums中，在此判断其与mid的值大小返回索引
            if (left > right) {
                if (target > nums[mid]) {
                    return mid + 1;
                } else {
                    return mid;
                }
            }
            if (target > nums[mid])
                left = mid + 1;
            if (target < nums[mid])
                right = mid - 1;
        }

    }
}
