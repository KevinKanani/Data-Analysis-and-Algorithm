import java.util.Scanner;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();

        int[] dimensions = new int[n + 1];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i <= n; i++) {
            dimensions[i] = scanner.nextInt();
        }

        int minMultiplications = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }

    private static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] dp = new int[n + 1][n + 1];

        // Initialize diagonal elements to 0
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }

        // Fill the dp table diagonally
        for (int chainLength = 2; chainLength <= n; chainLength++) {
            for (int i = 1; i <= n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n];
    }
}
