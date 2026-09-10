package leetcode.hashing;

import java.util.HashMap;


public class TwoSum {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/two-sum/description/">Two sum </a>
     * <b>Сложность: O(N)</b>
     * <b>Память:O(N)</b>
     * <p> <b>Метод решения</b> </p>
     * В хэш-мапу складываем значения данной ячейки и ее индекс,
     * если находим значение в мапе удовлетворяющее условию <code>(target - nums[i])</code>,
     * то достаем его  индекс и также текущее число т.е. i.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (hashNums.containsKey(target - nums[i])) {
                return new int[]{hashNums.get(target - nums[i]), i};
            }
            hashNums.put(nums[i], i);
        }
        return new int[] {-1,-1};


    }
    public static void main(String[] args){

        int[] nums = {2,7,11,15};
        TwoSum obTS = new TwoSum();
        obTS.twoSum(nums,9);
    }
}
