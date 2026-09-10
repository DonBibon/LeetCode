package leetcode.slidgingwindow;

import java.util.HashSet;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Longest Substring Without Repeating Characters</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(N) — в худшем случае каждый символ посещается дважды (один раз правым указателем, один раз левым).
 * <br><b>Space:</b> O(min(M, N)) — где M это размер алфавита, а N длина строки. В худшем случае размер HashSet ограничен алфавитом.
 * <p> <b>Метод решения (Скользящее окно динамического размера + HashSet)</b> </p>
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> letters = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); ++right) {
            char rightChar = s.charAt(right);

            while (letters.contains(rightChar)) {
                char leftChar = s.charAt(left);
                letters.remove(leftChar);
                ++left;
            }

            letters.add(rightChar);
            maxLen = Math.max(maxLen,letters.size());
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        var ob = new LongestSubstringWithoutRepeatingCharacters();
        System.out.print(ob.lengthOfLongestSubstring(s));
    }
}
