package prefixsum;

public class XORQueriesOfASubarray {
    /**
     * Ссылка на задачу: <a href="https://leetcode.com/problems/xor-queries-of-a-subarray/description/">XOR Queries of a Subarray (LeetCode 1310)</a>
     * <p><b>Сложность:</b>
     * <br><b>Time:</b> O(N + Q) — где N это длина массива arr (построение префиксного массива),
     * а Q — количество запросов в queries (но тут каждый ответ вычисляется за O(1)).
     * <br><b>Space:</b> O(N) — для хранения префиксного массива prefSum.
     * <p> <b>Метод решения (Префиксная/Кумулятивная сумма)</b> </p>
     * 1. Строим вспомогательный массив <code>prefSum</code>, где в ячейке <code>i</code> хранится результат
     * побитового XOR всех элементов от <code>0</code> до <code>i</code>.
     * 2. Для каждого запроса <code>[left, right]</code> вычисляем результат:
     * если <code>left == 0</code>, берем <code>prefSum[right]</code>;
     * иначе: <code>prefSum[right] ^ prefSum[left - 1]</code>,
     * что "отменяет" и отсекает ненужную левую часть массива.
     *
     * @param arr Входной массив целых чисел.
     * @param queries Массив запросов, где каждый запрос содержит диапазон <code>[left, right]</code>.
     * @return Массив ответов на каждый запрос.
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefSum = prefixSum(arr);
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; ++i){
            res[i] = sum(prefSum,queries[i]);
        }
        return res;
    }
    public int[] prefixSum(int[] arr){
        int[] prefSum = new int[arr.length];
        prefSum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i){
            prefSum[i] = prefSum[i-1] ^ arr[i];
        }

        return prefSum;
    }
    public int sum(int[] prefSum,int[] range){
        int right = range[1];
        int left = range[0];
        if (left == 0) {
            return prefSum[range[1]];
        }
        return prefSum[right] ^ prefSum[left - 1];

    }
    public static void main(String[] args){
        var ob = new XORQueriesOfASubarray();
        int[] arr = {16};
        int[][] queries  = { {0,0},{0,0},{0,0} };

        int[] res = ob.xorQueries(arr,queries);

        for (int i : res){
            System.out.print(i + " ");
        }
    }
}
