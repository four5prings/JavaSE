package HashTable_;

/**
 * @ClassName 快乐数
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 15:10
 * @Version 1.0
 */

import java.util.HashSet;

/**
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，
 * 那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        /**根据提议，sum可能会无限循环
         无限循环 =》 找到 循环出口的条件 1. 求和=1  2. 求和重复
         求和=1 就是 快乐数  求和重复 就是 会无限循环 那么也退出
         如何判断是否有重复 ，就需要用 set 集合存储数据，判断contains
         另一个难点
         如何对一个n 的各个位置 单独取数 并 处理
         */
        HashSet<Integer> record = new HashSet<>();
        int result = getNextNumber(n);
        //循环出口 n = 1 或者 n 重复
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    public int getNextNumber(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n = n / 10;
        }
        return sum;
    }
}
