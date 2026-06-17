//Given an array of integers, the task is to determine if it can be partitioned into two subsets such that the sum of elements in both subsets is equal. This problem can be solved using dynamic programming or recursion.
// {5,5,1,11} can be partitioned into two subsets {5,5,1} and {11} with equal sum 11.

public class Problem3EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {5,5,1,11,2,1};
        int n = arr.length;
        boolean isPossible = knapsack(arr, n);
        System.out.println("Is equal sum partition possible: " + isPossible);
    }

    public static boolean knapsack(int arr[], int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum%2!=0)
            return false;

        boolean [][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
