package leetcode.slidgingwindow;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/maximum-average-subarray-i/description/">Maximum Average Subarray I</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(N) — один проход по массиву.
 * <br><b>Space:</b> O(1) — константное использование памяти под переменные суммы.
 * <p> <b>Метод решения (Скользящее окно фиксированного размера)</b> </p>
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; ++i) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int right = k; right < nums.length; ++right) {
            windowSum += nums[right];
            windowSum -= nums[right - k];

            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum /k;
    }

    void main() {

    }
}
