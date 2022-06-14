package Array_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName binarySearch
 * @Description
 * @Author Four5prings
 * @Date 2022/4/23 23:17
 * @Version 1.0
 */
public class binarySearch {
    public static int search(int[] datas, int target) {
        if (datas.length <= 0) {
            throw new RuntimeException("array's length error");
        }
        //声明数组索引的标识
        int left = 0;
        int right = datas.length - 1;
        int mid = 0;
        //如果数组长度为偶数，则中间值偏左
        //如果数组长度为奇数，则在中间

        while (true) {
            mid = (left + right) / 2;
            if (datas[mid] == target)
                return mid;
            else if (left > right) {
                return -1;
            }
            //二分查找
            if (target > datas[mid]) {
                left = mid + 1;
            } else if (target < datas[mid]) {
                right = mid - 1;
            }
        }
    }

    @Test
    public void test_() {
        int[] datas = {3, 6, 7, 3, 2, 5, 6, 1, 10, 2, 8, 4};
        int a = 12;
        BubbleSort.bubbleSort(datas);
        System.out.println(Arrays.toString(datas));
        int result = search(datas, a);
        System.out.println(result);
    }
}
