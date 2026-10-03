package contestNum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task4 {
    int maxRoadLen(Scanner sc) {
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; ++i) {
            heights[i] = sc.nextInt();
        }
        int[] invariants = new int[n];

        for (int i = 0; i < n; i++) {
            invariants[i] = heights[i] - i;
        }
        Arrays.sort(invariants);
        int currLen = 1;
        int maxLen = currLen;
        for (int i = 1; i < n; ++i) {
            if (invariants[i] == invariants[i - 1]) {
                continue;
            }
            if (invariants[i] == invariants[i - 1] + 1) {
                ++currLen;
            } else {
                currLen = 1;
            }
            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Task4 ob = new Task4();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            sb.append(ob.maxRoadLen(sc)).append("\n");
        }
        System.out.println(sb.toString());
    }

}
