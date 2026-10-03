package contestNum;

import java.util.Scanner;

public class Task3 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int j = 0; j < t; ++j) {
            int n = sc.nextInt();

            char[] sArr = sc.next().toCharArray();
            int countZeros = 0;
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == '0') {
                    ++countZeros;
                }
            }
            if (sArr[0] == '1') {
                System.out.println(countZeros);
            } else {
                int countOnes = 0;
                int minMoves = Integer.MAX_VALUE;
                for (int i = 0; i < sArr.length; i++) {
                    if (sArr[i] == '1') {
                        ++countOnes;
                    }
                    if (sArr[i] == '0') {
                        --countZeros;
                    }
                    minMoves = Math.min(minMoves, countZeros + countOnes);
                }
                System.out.println(minMoves);
            }
        }

    }
}
