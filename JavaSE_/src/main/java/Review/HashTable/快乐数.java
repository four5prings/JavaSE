package Review.HashTable;

import java.util.HashSet;

/**
 * @ClassName 快乐数
 * @Description
 * @Author Four5prings
 * @Date 2022/5/8 16:38
 * @Version 1.0
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        HashSet<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            n = getNextNumber(n);
            record.add(n);
        }
        return n == 1;

    }

    public int getNextNumber(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
