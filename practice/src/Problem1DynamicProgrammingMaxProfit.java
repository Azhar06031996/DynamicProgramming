public class Problem1DynamicProgrammingMaxProfit {
    public static void main(String[] args) {
        int wt[] = {4,5,1};
        int val[] = {1,2,3};
        int W = 4;
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        int maxProfit = knapsack(wt, val, W, n);
        System.out.println("Max profit is: " + maxProfit);

    }

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + knapsack(wt,val,W-wt[i-1], n-1), knapsack(wt, val, W, n-1));
                }
                else {
                    dp[i][j] = knapsack(wt, val, W, n-1);
                }
            }
        }
        return dp[n][W];
    }
}
