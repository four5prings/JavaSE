package Array_;

/**
 * @ClassName 二分查找
 * @Description
 * @Author Four5prings
 * @Date 2022/4/30 15:11
 * @Version 1.0
 */
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target,
// 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//数组是存放在连续内存空间上的相同类型数据的集合。
//数组下标都是从0开始的。
//数组内存空间的地址是连续的
public class 二分查找 {
    public static int search(int[] nums, int target) {
        if (nums.length <= 0) {
            throw new RuntimeException("target array error");
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (true) {
            mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            if (left > right)
                return -1;
            if (target > nums[mid])
                left = mid + 1;
            if (target < nums[mid])
                right = mid - 1;
        }
    }
}
