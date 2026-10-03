package introduction;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int countMax = 1;
        int currentCount = 1;

        for (int i = 1; i < input.length(); ++i){
            if (input.charAt(i - 1) == input.charAt(i)){
                ++currentCount;
                if (currentCount > countMax){
                    countMax = currentCount;
                }
                continue;
            }

            currentCount = 1;
        }
        System.out.print(countMax);
    }
}
