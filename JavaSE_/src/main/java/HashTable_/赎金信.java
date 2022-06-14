package HashTable_;

/**
 * @ClassName 赎金信
 * @Description
 * @Author Four5prings
 * @Date 2022/5/5 18:05
 * @Version 1.0
 */
//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
// 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
// 如果可以构成，返回 true ；否则返回 false。
//(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
// 杂志字符串中的每个字符只能在赎金信字符串中使用一次。你可以假设两个字符串均只含有小写字母。)
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        /**
         * 可以采用将ransom中的字符全部记录到数组中，用字符-‘a’所显示的索引作为字符，
         * 出现的次数作为 数据 然后 在 遍历这个杂志，将所出现的字符-1 ，最后遍历这个记录的
         * 数组，如果存在正数 ，那么就不能构成
         */
        int[] record = new int[26];
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i > 0)
                return false;
        }
        return true;

    }
}
