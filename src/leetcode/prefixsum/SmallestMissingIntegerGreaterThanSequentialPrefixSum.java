package leetcode.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/">Smallest Missing Integer Greater Than Sequential Prefix Sum (LeetCode 2996)</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N^2) — поиск <code>nums.contains()</code> в списке работает за O(N) на каждой итерации цикла while.
     * <br><b>Space:</b> O(N) — память под список префикса <code>pref</code> и список упакованных чисел <code>numsList</code>.
     * <p> <b>Метод решения</b> </p>
     * 1. Собираем последовательный префикс (где каждый следующий элемент больше предыдущего на 1) в список <code>pref</code>.
     * 2. Преобразуем исходный массив примитивов в List с помощью Stream API.
     * 3. В методе <code>checkNum</code> вычисляем сумму элементов префикса.
     * 4. В цикле <code>while (true)</code> перебираем числа, начиная с полученной суммы (<code>sum + i</code>),
     * и возвращаем первое число, которого нет в списке <code>nums</code>.
     *
     * @param nums Входной массив целых чисел.
     * @return Наименьшее отсутствующее число, большее или равное сумме последовательного префикса.
     * <p>TODO: использовать обертки не оптимально, написать функцию вручную или переделать под HashSet </p>
     * !!! Точно переделать под HashSet, скорость станет O(N) !!!
     */
    public int missingInteger(int[] nums) {
        List<Integer> pref = new ArrayList<>();
        pref.add(nums[0]);
        for (int i = 1; i <  nums.length ; i++){
            if (nums[i] == nums[i - 1]) break;

            if (nums[i] - nums[i - 1] == 1){
                pref.add(nums[i]);
            }else break;
        }

        List<Integer> numsList = Arrays.stream(nums)
                        .boxed()
                        .toList();
        return checkNum(pref,numsList);
    }
    public int checkNum(List<Integer> pref, List<Integer>nums){
        int sum = 0;
        for(int i : pref){
            sum +=i;
        }
        int i = 0;
        while (true){
            int res = sum + i;
            if (nums.contains(res)){
                ++i;
                continue;
            }
            return res;
        }
    }
    public static void main(String[] args){
        var ob = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();
        int[] nums = {23,24,25,4,5,1};
        System.out.println(ob.missingInteger(nums));
    }
}
