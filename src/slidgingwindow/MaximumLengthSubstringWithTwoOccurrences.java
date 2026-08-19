package slidgingwindow;

import java.util.HashMap;

public class MaximumLengthSubstringWithTwoOccurrences {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/">Maximum Length Substring With Two Occurrences (LeetCode 3090)</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N^2)
     * <br><b>Space:</b> O(N) — память под массив символов sChar, StringBuilder и HashMap частот символов.
     * <p> <b>Метод решения (Полный перебор / Brute Force)</b> </p>
     * 1. Внешним циклом фиксируем начало подстроки <code>i</code>, внутренним циклом <code>j</code> расширяем подстроку вправо.
     * 2. Ведем подсчет частоты символов в <code>HashMap freq</code>.
     * 3. Если символ встречается $\le 2$ раз, добавляем его в <code>StringBuilder res</code>; если чаще — прерываем внутренний цикл.
     * 4. Обновляем максимальную длину <code>counter</code>, после чего очищаем <code>res</code> и мапу <code>freq</code> для следующего шага.
     *
     * @param s Входная строка, состоящая из строчных английских букв.
     * @return Максимальная длина подстроки, где каждый символ встречается не более двух раз.
     *<p>TODO:Решение не оптимально, изучить и реализовать вариант с паттерном скользящее окно</p>
     */
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        char[] sChar = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int counter = 0;
        char curr;
        for (int i = 0; i < s.length(); ++i){

            for (int j = i; j < s.length() ; ++j){
                curr = sChar[j];
                freq.put(curr,freq.getOrDefault(curr,0) + 1);

                if (freq.get(curr) <= 2){
                    res.append(curr);
                }else{
                    break;
                }

            }
            if (res.length() > counter){
                counter = res.length();
            }
            res.setLength(0);
            freq.clear();
        }
        return counter;
    }
    public static void main(String[] args){
        var ob = new MaximumLengthSubstringWithTwoOccurrences();
        String s = "aaaa";
        System.out.println(ob.maximumLengthSubstring(s));
    }
}
