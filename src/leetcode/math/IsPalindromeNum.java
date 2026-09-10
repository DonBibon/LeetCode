package leetcode.math;

import java.util.ArrayList;

public class IsPalindromeNum {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/palindrome-number/description/">Palindrome Number</a>
     *
     * <b>Сложность: O(log N) (или O(кол-во цифр числа))</b>
     * <p> <b>Метод решения</b> </p>
     * Отсекаем отрицательные числа (они не палиндромы). Создаем копию числа.
     * В цикле откусываем последнюю цифру через остаток от деления <code>(copX % 10)</code>
     * и "собираем" новое число задом наперед, умножая текущий результат <code>(rev)</code> на 10 и прибавляя откусанную цифру.
     * В конце сравниваем перевернутое число <code>(rev)</code> с изначальным <code>x</code>.
     * <b>v2</b>
     * Это моя первая попытка написания, алгоритм работает, но требует O(N) памяти и по скорости выигрыша нет.
     * Просто то, что пришло мне в голову.
     */
    public boolean isPalindromev2(int x){
        int copX = x;
        ArrayList<Integer> sInt = new ArrayList<>();
        if (x >= 0){
            while (copX != 0){
                sInt.add((copX)%10);
                copX/=10;

            }
            int guard = 0;
            for(int i = 0; i < sInt.size();i++ ){
                if (sInt.get(i).equals(sInt.get(sInt.size() - 1 - i))){
                    ++guard;
                }
            }
            return guard == sInt.size();
        }
        return false;
    }
    public boolean isPalindrome(int x){
        int rev = 0;

        int copX = x;
        if (x < 0) return false;
        while (copX != 0){

            int digit = copX % 10;
            rev = (rev*10) + digit;
            copX = copX/10;
        }

        return (rev == x);
    }
     static void main(String[] args){
        int x  =1221;
        var ob = new IsPalindromeNum();
        System.out.print(ob.isPalindrome(x));
    }
}
