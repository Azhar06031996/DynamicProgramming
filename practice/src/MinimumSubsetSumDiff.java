//Given an array {1,2,7} split it into 2 sub-arrays such that the difference of sum of both arrays is minimum. The output should be 4 as the two subsets {1,2} and {7} have a difference of 4. The problem can be solved using dynamic programming or recursion.
//Assuming s2 to be greater than s1, the difference can be calculated as s2-s1 = (s1+s2)-2*s1 = sum-2*s1. The problem can be reduced to finding the maximum value of s1 such that s1 <= sum/2. The maximum value of s1 can be found using the subset sum problem.
//Range will be maximum when s2 has all elements ans s1 has none. Hence the max range will be from 0 to sum of array.
//Hence create a DP matric from 0 to sum and then iterate through the last row to identify min value using formula sum-2*s1 should be minimum.
//Iterate only half of the last row as s1 should be less than or equal to sum/2. The minimum value will be the answer.

public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        int arr[] = {1,2,7};
        int sum=0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
        }
        int result = knapsack(arr, sum);
        System.out.println("Minimum subset sum difference is: " + result);
    }

    public static int knapsack(int arr[], int sum) {
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        //initializing the first row and column in array.
        for(int i=0;i<arr.length+1;i++) {
            for(int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        }
        //initialize the other elements in the matrix
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        boolean[] possibleSums = new boolean[sum/2 + 1];
        for(int i=0;i<sum/2+1;i++){
            possibleSums[i] = dp[arr.length][i];
        }
        int minimumDifference = Integer.MAX_VALUE;
        for(int i=0;i< possibleSums.length;i++){
            if(possibleSums[i])
                minimumDifference = Math.min(minimumDifference, sum - 2*i);
        }
        return minimumDifference;
    }
}
