package HashTable_;

import java.util.HashMap;

/**
 * @ClassName 四数相加II
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 17:05
 * @Version 1.0
 */
//给定四个包含整数的数组列表 A , B , C , D ,
// 计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
//为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
// 所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
public class 四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> record = new HashMap<>();
        int tmp;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                tmp = nums1[i] + nums2[j];
                if (record.containsKey(tmp)) {
                    record.put(tmp, record.get(tmp) + 1);
                } else {
                    record.put(tmp, 1);
                }
            }
        }
        int result = 0;
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                tmp = nums3[k] + nums4[l];
                if (record.containsKey(-tmp)) {
                    result += record.get(-tmp);
                }
            }
        }
        return result;


        //超时 -弱智解法
        /*int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (nums1[i]+nums2[j]+nums3[k]+nums4[l]==0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;*/
    }
}
