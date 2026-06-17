//Given an array and a target sum, find the number of subsets which sums up to target
//For the given input output should be 3 as there are three subsets {2,3,5}, {2,8} and {10} with sum 10.
public class Problem4CountOfSubsetOfGivenSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;
        int n = arr.length;
        int count = knapsack(arr, sum, n);
        System.out.println("Count of subsets with given sum: " + count);
    }

    public static int knapsack(int[] arr, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for(int j=0;j<W+1;j++){
                if(i==0)
                    dp[i][j] = 0;
                //disable and check
                if(j==0)
                    dp[i][j] = 1;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}
