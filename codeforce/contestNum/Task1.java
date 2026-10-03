package contestNum;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++){
            int n = sc.nextInt();
            int[] a = new int[3];

            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }

            int min = Integer.MAX_VALUE;
            for (int i : a) {
                if (i < min) {
                    min = i;
                }
            }
            int res = n - min;
            System.out.println(res);
        }

    }
}