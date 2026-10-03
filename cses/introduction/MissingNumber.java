package introduction;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() ;
        long sumTheory = (n * (n + 1))/2;
        long sumReal = 0;
        for (int i = 0; i < n - 1; i++){
             sumReal +=sc.nextInt();
        }
        System.out.print(sumTheory - sumReal);
    }
}