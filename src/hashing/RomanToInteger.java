package hashing;

import java.util.HashMap;

public class RomanToInteger {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/roman-to-integer/description/">Roman to Integer</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N) — где N длина строки (проходим по строке один раз).
     * <br><b>Space:</b> O(N) — создаем перевернутую копию строки в виде массива char.
     * <p> <b>Метод решения</b> </p>
     * Инициализируем мапу со значениями римских цифр. Разворачиваем строку задом наперед
     * и идем слева направо (от младших разрядов к старшим).
     * Храним максимальный встреченный символ <code>maxEl</code>:
     * если текущее число больше или равно максимальному — прибавляем его к результату и обновляем максимум,
     * если меньше, то вычитаем (ситуации вроде IV, IX, XC).
     * <p>TODO: навалил кринжа с переворотом строки, переделать под простой цикл</p>
     */
    private HashMap<Character,Integer> romanHT(){
        HashMap<Character,Integer> RomanMap = new HashMap<>();
        RomanMap.put('I',1);
        RomanMap.put('V',5);
        RomanMap.put('X',10);
        RomanMap.put('L',50);
        RomanMap.put('C',100);
        RomanMap.put('D',500);
        RomanMap.put('M',1000);
        return RomanMap;
    }
    public int romanToInt(String s) {
        HashMap<Character,Integer> RomanMap = romanHT();

        StringBuilder sb = new StringBuilder(s);
        char[] romMas = sb.reverse().toString().toCharArray();

        char maxEl = romMas[0];
        int counter = RomanMap.get(romMas[0]);
        for (int i = 1; i < romMas.length; i++){
            if (RomanMap.get(romMas[i]) >= RomanMap.get(maxEl)){
                maxEl = romMas[i];
                counter += RomanMap.get(romMas[i]);
            }else{
                counter -= RomanMap.get(romMas[i]);
            }

        }
        return counter;
    }
}
