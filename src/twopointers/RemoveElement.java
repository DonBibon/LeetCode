package twopointers;

public class RemoveElement {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/remove-element/description/">Remove Element</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N) — проходим по массиву ровно один раз.
     * <br><b>Space:</b> O(1) — работаем in-place, дополнительная память не выделяется.
     * <p> <b>Метод решения (Два указателя: Читатель и Писатель)</b> </p>
     * Используем два указателя: <code>i</code> (читатель) обходит весь массив,
     * а <code>k</code> (писатель) указывает на индекс, куда нужно сохранить следующий "хороший" элемент.
     * Если <code>nums[i] != val</code>, записываем значение на позицию <code>nums[k]</code> и инкрементируем <code>k</code>.
     * Элементы, равные <code>val</code>, просто затираются последующими значениями.
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] != val){
                nums[k] = nums[i];
                ++k;
            }

        }
        return  k;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int val = 1 ;
        var ob = new RemoveElement();

        System.out.println( ob.removeElement(nums, val));
        for (int i : nums){
            System.out.print(i);
        }
    }
}
