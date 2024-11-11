import java.util.Arrays;

public class CoinChangeDP {

    public static int makeChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with a value greater than the amount
        dp[0] = 0; // Base case: 0 coins needed to make change for 0 amount

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int minCoins = makeChange(coins, amount);
        System.out.println("Minimum coins required: " + minCoins);
    }
}
