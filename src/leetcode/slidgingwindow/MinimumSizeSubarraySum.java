package leetcode.slidgingwindow;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/minimum-size-subarray-sum/description/">Minimum Size Subarray Sum</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(N) — каждый элемент массива обрабатывается указателями <code>left</code> и <code>right</code> не более одного раза.
 * <br><b>Space:</b> O(1)
 * <p> <b>Метод решения (Скользящее окно динамического размера)</b> </p>
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int currSize = 0;
        int currSum = 0;



        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];

            while ( currSum >= target ) {
                minSize = Math.min(right - left + 1,minSize);
                currSum -= nums[left];
                ++left;
            }

        }

        if (minSize != Integer.MAX_VALUE) {
            return minSize;
        } else {
            return 0;
        }
    }
    void main() {
        var ob = new MinimumSizeSubarraySum();
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.print(ob.minSubArrayLen(213,nums));
    }
}
