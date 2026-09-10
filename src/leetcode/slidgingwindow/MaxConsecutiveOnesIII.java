package leetcode.slidgingwindow;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/max-consecutive-ones-iii/description/">Max Consecutive Ones III</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(N) — правый и левый указатели проходят по массиву максимум по одному разу.
 * <br><b>Space:</b> O(1) — дополнительная память не требуется.
 * <p> <b>Метод решения (Скользящее окно динамического размера)</b> </p>
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {

        int currZeros = 0;

        int left = 0;

        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                ++currZeros;
            }
            while (currZeros > k) {
                if (nums[left] == 0) {
                    --currZeros;
                }
                ++left;


            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    void main() {
        var ob = new MaxConsecutiveOnesIII();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.print(ob.longestOnes(nums,k));
    }
}
