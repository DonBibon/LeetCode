package otherresource;

class ObjectToSteal {
    private final int value;
    private final int weight;

    ObjectToSteal(int value, int space) {
        this.value = value;
        this.weight = space;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}

public class backpack {
    void main() {
        var guitar = new ObjectToSteal(1500, 1);
        var laptop = new ObjectToSteal(2000, 3);
        var speaker = new ObjectToSteal(3000, 4);
        ObjectToSteal[] stealob = {guitar,laptop,speaker};

        int maxWeight = 4;
        int[][] dp = new int[stealob.length + 1][maxWeight + 1];
        for (int i = 1; i < stealob.length + 1; i++) {
            var currOb = stealob[i - 1];
            for (int j = 1; j < maxWeight + 1; j++) {
                if (j - currOb.getWeight() < 0) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            currOb.getValue() + dp[i - 1][j - currOb.getWeight()]  );

                }

            }
        }

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j  < dp[i].length; j++ ) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }


}
