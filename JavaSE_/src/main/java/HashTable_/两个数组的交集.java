package HashTable_;

import java.util.HashSet;

/**
 * @ClassName 两个数组的交集
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 14:15
 * @Version 1.0
 */
//题意：给定两个数组，编写一个函数来计算它们的交集。
// 说明： 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。

public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {

        //声明set集合用来存储数据， 因为题中出现唯一，那么可以想到去重！！！
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> record = new HashSet<>();
        //将第一个数组元素储存
        for (int i : nums1) {
            set1.add(i);
        }
        //存储第二个set集合数据时，对数据进行判断，判断第一个集合是否有该数据，有数据则存储
        for (int i : nums2) {
            if (set1.contains(i))
                record.add(i);
        }
        //将set转换为数组
        int[] result = new int[record.size()];
        int index = 0;
        for (Integer i : record) {
            result[index++] = i;
        }
        return result;
    }
}
