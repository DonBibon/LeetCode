package leetcode.linkedlist;
/**
 * Ссылка на задачу: <a href="https://leetcode.com/problems/add-two-numbers/description/">Add Two Numbers</a>
 * <p><b>Сложность:</b>
 * <br><b>Time:</b> O(max(N, M)) — где N и M это длины связанных списков l1 и l2. Проходим по спискам один раз.
 * <br><b>Space:</b> O(max(N, M)) — память выделяется под новый связанный список, длина которого равна максимальной из длин исходных списков (плюс возможно 1 узел для остатка).
 * <p> <b>Метод решения (Имитация сложения столбиком)</b> </p>
 * Создаем фиктивный узел <code>dummyHead</code>, который упрощает логику возврата результата.
 * В цикле проходим по обоим спискам одновременно, пока не закончатся узлы в обоих списках и не обнулится перенос разряда <code>carryDig</code>.
 * На каждой итерации складываем значения узлов (если они есть) и перенос с прошлого шага.
 * Вычисляем новый перенос <code>sum / 10</code> и записываем в новый узел остаток от деления <code>sum % 10</code>.
 * Сдвигаем указатели списков и продолжаем процесс.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode res = dummyHead;
        int carryDig = 0;
        while (l1 != null || l2 != null || carryDig != 0){
            int sum;

            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            sum = val1 + val2 + carryDig;
            carryDig = sum/10;
            sum = sum%10;

            res.next = new ListNode(sum);
            res = res.next;




            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }
        return dummyHead.next;
    }
    void main(){
        var ob = new AddTwoNumbers();
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        var res = ob.addTwoNumbers(l1,l2);
    }


    public class ListNode {
         int val;
         ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      }

}
