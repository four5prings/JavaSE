package HashTable_;

/**
 * @ClassName 三数之和
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 18:14
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 */
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         * 双指针法
         * 因为是同一个数组，而且只要求返回数值而非下标，那么就可以排序之后对数组进行处理
         *
         * 一层for循环，再i to nums.length-1 之间定义双指针
         * left = i+1 ，right=length-1 判断三者之和，大于0 则right左移，小于0则left右移
         * 这次循环的条件就是left=right 时，进入下一个循环
         *
         */
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left--;

                    right--;
                    left++;
                }
            }
        }
        return result;
        /**
         * 先计算两个数之和，将数据进行存储，再遍历数组，找到第三个数 = - tmp
         * a + b = -c 使用这个来计算 但是又不能有重复的三元组
         * 可以再最后add 的时候再
         * 以下是错误代码
         */
        /*if (nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> record = new HashMap<>();
//        ArrayList<Integer> tmpList = new ArrayList<>();
        int tmp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                tmp = nums[i] + nums[j];
                ArrayList<Integer> tmpList = new ArrayList<>();
                tmpList.add(nums[i]);//这里的tmpList的值会覆盖之前的存储数据，且无法去重
                tmpList.add(nums[j]);
                tmpList.add(i);
                tmpList.add(j);
                record.put(tmp, tmpList);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(-nums[i])) {
                //获取相应值的value ，这里面含有之前记录的两个不重复的值，以及数组下标
                List<Integer> tmpindex = record.get(-nums[i]);
                Integer firstvalue = tmpindex.get(0);
                Integer secondvalue = tmpindex.get(1);
                Integer firstindex = tmpindex.get(2);
                Integer secondindex = tmpindex.get(3);
                if (i != firstvalue && i != secondvalue) {
                    ArrayList<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(firstindex);
                    tmpList.add(secondindex);
                    result.add(tmpList);
                    tmpList.clear();
                }
            }
        }
        return result;*/
    }
}
