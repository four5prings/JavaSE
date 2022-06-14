package Array_;

import org.junit.Test;

/**
 * @ClassName BubbleSort_
 * @Description
 * @Author Four5prings
 * @Date 2022/4/23 23:04
 * @Version 1.0
 */
public class BubbleSort {
    @Test
    public void test(){
        int[] datas = {1,3,5,7,4,7,8,2,4};
        bubbleSort(datas);
        print(datas);
    }

    public static void bubbleSort(int[] datas) {
        if (datas.length <= 0) {
            throw new RuntimeException("array's length error ");
        }

        for (int i = 0; i < datas.length; i++) {
            int tmp = 0;
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    tmp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = tmp;
                }
            }
        }
    }
    public static void print(int[] datas) {
        String a = " ";
        for (int i = 0; i < datas.length; i++) {
            a += datas[i];
        }
        System.out.println(a);
    }
}

