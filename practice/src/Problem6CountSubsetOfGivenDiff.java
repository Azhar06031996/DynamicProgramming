//Given an array {1,1,2,3} and diff =1, find how many subsets can be created with diff =1, output should be 3 for this input
//We have s1-s2 = diff, s1+s2 = sum, hence s1 = (diff+sum)/2. Hence the problem can be reduced to finding the number of subsets with sum = (diff+sum)/2. The problem can be solved using dynamic programming or recursion.
//Find how many subsets can be created with sum = (diff+sum)/2. The problem can be solved using dynamic programming or recursion.

public class Problem6CountSubsetOfGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        int requiredSubsetSum = (diff + sum) / 2;
        int count = knapsack(arr, requiredSubsetSum);
        System.out.println("Number of subsets with given difference: " + count);
    }

    public static int knapsack(int[] arr, int sum) {
        int n = arr.length;
        int dp[][] = new int [n+1][sum+1];
        //initialise first row and column
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j] = 0;
                if(j==0)
                    dp[i][j] = 1;
            }
        }

        //initialise remaining matrix elements.
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
