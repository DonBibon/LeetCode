package introduction;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; ++i){
            nums[i] = sc.nextLong();
        }

        long prev = nums[0];
        long counter = 0;
        for (int i = 0; i < n; ++i){
            if (nums[i] >= prev){
                prev = nums[i];
                continue;
            }
            counter += (prev - nums[i]);
            nums[i] += (prev - nums[i]);
            prev = nums[i];
        }
        System.out.print(counter);
    }
}
