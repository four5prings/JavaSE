package Array_;

/**
 * @ClassName 螺旋矩阵
 * @Description
 * @Author Four5prings
 * @Date 2022/5/1 11:11
 * @Version 1.0
 */
//给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，
// 且元素按顺时针顺序螺旋排列的正方形矩阵。
public class 螺旋矩阵 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        //声明赋值元素
        int count = 1;
        int loop = n / 2;
        //每次循环的起始位置
        int startx = 0;
        int starty = 0;
        //定义偏移量 控制遍历的长度
        int offset = 1;
        //定义中间位置
        int mid = n / 2;
        while (loop > 0) {
            int i = startx;
            int j = starty;
            //上侧从左到右 (左闭右开)
            for (; j < starty + n - offset; j++) {
                nums[i][j] = count++;
            }
            //右侧从上到下 (左闭右开)
            for (; i < startx + n - offset; i++) {
                nums[i][j] = count++;
            }
            //下册从右到左 (左闭右开)
            for (; j > starty; j--) {
                nums[i][j] = count++;
            }
            //左侧从下到上 (左闭右开)
            for (; i > startx; i--) {
                nums[i][j] = count++;
            }
            loop--;
            startx++;
            starty++;
            offset += 2;
        }
        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1) {
            nums[mid][mid] = count;
        }
        return nums;
    }
}
