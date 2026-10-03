package introduction;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            long n = sc.nextInt();

            StringBuilder answer = new StringBuilder();
            answer.append(n).append(" ");
            while (n != 1){
                if (n % 2 == 0){
                    n = n / 2;
                    answer.append(n).append(' ');
                }else {
                    n = (n * 3) + 1;
                    answer.append(n).append(' ');
                }
            }
            System.out.print(answer.toString());

    }
}
