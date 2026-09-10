package leetcode.slidgingwindow;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/">Maximum Number of Vowels in a Substring of Given Length</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(N) — проходим по строке ровно один раз.
 * <br><b>Space:</b> O(1) — используем только несколько переменных для счетчиков.
 * <p> <b>Метод решения (Скользящее окно фиксированного размера)</b> </p>

 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int maxVowel  = 0;
        int winSum = 0;
        for (int right = 0; right < k; right++){
            char curr = s.charAt(right);
            if (curr == 'e'
                    || curr == 'i'
                    || curr == 'a'
                    || curr == 'o'
                    || curr == 'u') {
                ++winSum;
            }
        }
        maxVowel = winSum;

        for (int right  = k; right < s.length(); ++right) {
            char charOnRight = s.charAt(right);
            char charOnLeft = s.charAt(right - k);
            if (charOnRight == 'e'
                    || charOnRight == 'i'
                    || charOnRight == 'a'
                    || charOnRight == 'o'
                    || charOnRight == 'u') {
            ++winSum;
            }
            if (charOnLeft == 'e'
                    || charOnLeft == 'i'
                    || charOnLeft == 'a'
                    || charOnLeft == 'o'
                    || charOnLeft == 'u') {
                    --winSum;
            }

            maxVowel = Math.max(maxVowel,winSum);

        }
        return maxVowel;
    }
    public static void main(String[] args) {
        var ob = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        String s = "leetcode";
        System.out.print(ob.maxVowels(s,2));
    }
}
