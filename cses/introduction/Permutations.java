package introduction;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() ;
        StringBuilder answer = new StringBuilder();

        if (n == 1){
            System.out.print('1');
        } else {
            if (n > 3){
                for (int i = 2; i < n + 1; i+=2) {
                    answer.append(i).append(" ");
                }
                for (int i = 1; i < n + 1; i +=2){
                    answer.append(i).append(" ");
                }
                System.out.print(answer.toString());
            } else {
                System.out.print("NO SOLUTION");
            }
        }




    }
}
