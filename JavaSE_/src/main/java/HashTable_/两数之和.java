package HashTable_;

/**
 * @ClassName 两数之和
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 15:37
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        /*首先建立一个集合， 将数组中的数据存储起来
         遍历数组，第一个值位 nums[i] ,那么 另一个值为target-nums[i]
         判断 另一个值是否在 集合中 ，并返回这个值的下标
         如果下标不一样 那么就返回这个值
         */
        //暴力解法--太拉了52 ms, 在所有 Java 提交中击败了28.01%的用户
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = target - nums[i];
                if (nums[j] == tmp) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param nums
     * @param target
     * @return 使用hashmap 先存入目标数组，将数据为key，索引作为value，这样就不会被去重
     * 然后 遍历数组， 查看是否有containsKey 然后再判断 value是否不等 返回数组
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (record.containsKey(tmp)) {
                Integer j = record.get(tmp);
                if (i != j) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;

    }

    /**
     * Carl哥代码
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 大佬代码
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.get(dif) != null) {
                res[0] = map.get(dif);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
