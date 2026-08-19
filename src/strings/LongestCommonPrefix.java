package strings;

public class LongestCommonPrefix {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/longest-common-prefix/description/">Longest Common Prefix</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N * M) — где N это количество слов, а M — длина самого короткого слова.
     * <br><b>Space:</b> O(M) — память под StringBuilder для хранения результирующего префикса.
     * <p> <b>Метод решения (Вертикальное сканирование)</b> </p>
     * Находим длину самого короткого слова, чтобы гарантированно не выйти за границы строк.
     * Внешним циклом идем по индексам символов (колонкам). Во внутреннем цикле сравниваем символ
     * текущей позиции с символом первого слова во всех остальных строках.
     * Если символ совпал у всех строк — добавляем его в <code>StringBuilder</code>.
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String constWord = strs[0];

        for ( int i = 0; i < minLength(strs); ++i){
            int checkSumFlags = 0;
            for (int j = 1; j < strs.length ; ++j){

                if (strs[j].charAt(i) == constWord.charAt(i) ){
                    ++checkSumFlags;

                }
            }
            if (checkSumFlags == strs.length - 1) {
                res.append(constWord.charAt(i));
            }else break;
        }
        return res.toString();
    }
    int minLength(String[] strs){
        int minLenght = strs[0].length();
        for (String i : strs){
            if (i.length() < minLenght){
                minLenght = i.length();
            }
        }
        return minLenght;
    }
    public static void main(String[] args){
        String[] strs = {"cir","car"};
        LongestCommonPrefix ob = new LongestCommonPrefix();
        System.out.println(ob.longestCommonPrefix(strs));


    }
}
