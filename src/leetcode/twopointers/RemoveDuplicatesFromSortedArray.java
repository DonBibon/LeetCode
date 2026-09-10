package leetcode.twopointers;

public class RemoveDuplicatesFromSortedArray {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">Remove Duplicates from Sorted Array</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N^2) — из-за метода сдвига <code>moveList</code>, который при каждом дубликате перемещает элементы за O(N).
     * <br><b>Space:</b> O(1) — алгоритм работает in-place, дополнительная память не выделяется.
     * <p> <b>Метод решения (Сдвиг дубликатов в конец массива)</b> </p>
     * Проходим по массиву циклом <code>while</code> до динамической границы <code>nums.length - k</code>,
     * где <code>k</code> — количество найденных дубликатов (мусорная зона в конце массива).
     * Если текущий элемент равен предыдущему, вызываем метод <code>moveList</code>, который циклически сдвигает
     * дубликат в конец массива, увеличиваем <code>k</code> и остаемся на текущем индексе <code>i</code> для проверки нового элемента.
     * Если элементы разные — делаем шаг вперед (<code>++i</code>).
     * В конце возвращаем количество уникальных элементов: <code>nums.length - k</code>.
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;

        int i = 1;
        while (i < nums.length - k) {

            int prev = i - 1;
            if (nums[prev] != nums[i]){
                ++i;
                continue;
            }
            moveList(i,nums);
            k +=1;
        }
            return nums.length - k;
    }
    void moveList(int red,int[] nums ){
        int buf = nums[red];
        for ( int i = red; i < nums.length - 1; i++){
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = buf;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray ob = new RemoveDuplicatesFromSortedArray();
        ob.removeDuplicates(nums);

    }
}


