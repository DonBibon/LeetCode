package contestNum;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i){
            long a = sc.nextInt();
            long b = sc.nextInt();
            long c = sc.nextInt();

            long curr_res = Math.abs(a - b);

            long absAlice = Math.abs(a + c - b);
            if (curr_res > absAlice) {
                System.out.println(curr_res);
            }else {
                System.out.println( absAlice);
            }
        }



    }
}
