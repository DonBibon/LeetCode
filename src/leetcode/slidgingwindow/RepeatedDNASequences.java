package leetcode.slidgingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/repeated-dna-sequences/description/">Repeated DNA Sequences</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(N)
 * <br><b>Space:</b> O(N)
 * <p> <b>Метод решения (Скользящее окно фиксированного размера + Хэширование)</b> </p>

 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String currSeq = s.substring(i, i + 10);
            if (!seen.add(currSeq)){
                repeated.add(currSeq);
            }


        }
        return new ArrayList<>(repeated);
    }
    void main() {
        String s = "AAAAAAAAAAAAA";
        var ob = new RepeatedDNASequences();
        System.out.print(ob.findRepeatedDnaSequences(s));
    }
}
