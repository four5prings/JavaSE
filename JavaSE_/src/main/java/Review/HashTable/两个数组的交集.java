package Review.HashTable;

import java.util.HashSet;

/**
 * @ClassName 两个数组的交集
 * @Description
 * @Author Four5prings
 * @Date 2022/5/8 16:05
 * @Version 1.0
 */
//题意：给定两个数组，编写一个函数来计算它们的交集。
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> record = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i : nums1) {
            record.add(i);
        }
        for (int i : nums2) {
            if (record.contains(i))
                result.add(i);
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            res[index++] = i;
        }
        return res;
    }
}
