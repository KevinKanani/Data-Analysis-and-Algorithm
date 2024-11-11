
import java.util.Arrays;

public class MakeChangeGreedy {

    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1}; // Coin denominations in descending order
        int amount = 63;

        int[] change = makeChange(coins, amount);
        System.out.println("Coins used: " + Arrays.toString(change));
    }

    public static int[] makeChange(int[] coins, int amount) {
        int[] change = new int[coins.length];
        int remainingAmount = amount;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= remainingAmount) {
                change[i] = remainingAmount / coins[i];
                remainingAmount %= coins[i];
            }
        }

        return change;
    }
}

        