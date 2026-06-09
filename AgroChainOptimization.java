import java.util.*;

class Activity {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class AgroChainOptimization {

    // Activity Scheduling (Greedy)
    static void activitySelection(Activity activities[]) {

        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        System.out.println("Selected Farming Activities:");

        int lastFinish = activities[0].finish;
        System.out.println("(" + activities[0].start + ", " +
                           activities[0].finish + ")");

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinish) {
                System.out.println("(" + activities[i].start + ", " +
                                   activities[i].finish + ")");
                lastFinish = activities[i].finish;
            }
        }
    }

    // 0/1 Knapsack (Dynamic Programming)
    static int knapsack(int capacity, int weights[],
                        int profits[], int n) {

        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {

                if (i == 0 || w == 0)
                    dp[i][w] = 0;

                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(
                            profits[i - 1]
                                    + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]);

                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        // Activity Scheduling Example
        Activity activities[] = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(4, 7),
                new Activity(1, 8),
                new Activity(8, 9)
        };

        activitySelection(activities);

        // Knapsack Example
        int profits[] = {60, 100, 120};
        int weights[] = {10, 20, 30};
        int capacity = 50;

        int maxProfit = knapsack(
                capacity, weights, profits, profits.length);

        System.out.println("\nMaximum Transport Profit: "
                + maxProfit);
    }
}