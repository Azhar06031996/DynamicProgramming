//Given an array {2,3,7,8,10} and a sum 11, the output should be true as there is a subset {3,8} with sum 11.
//If output is false, then there is no subset with sum 11. The problem can be solved using dynamic programming or recursion.
public class Problem2IsSubsetPossible {
    public static void main(String[] args) {
        int[] wt = {2,3,7,8,10};
        int W = 11;
        int n= wt.length;
        boolean isPossible = knapsack(wt, W, n);
        System.out.println("Is subset possible: " + isPossible);
    }

    public static boolean knapsack(int[] wt, int W, int n){
        boolean[][] dp = new boolean[n + 1][W + 1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1] <= j){
                    dp[i][j] = dp[i-1][j-wt[i-1]] || dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}
