//In the 0/1 knapsack problem, each item can either be fully included or excluded; fractions are not allowed. Given arrays of item values val[] and weights wt[],
// and a knapsack capacity W, the goal is to select items such that the total value is maximized while the total weight does not exceed W

public class Problem1RecursiveMaxProfit {
    public static void main(String[] args) {
        int wt[] = {3,4,5,6};
        int val[] = {2,3,4,1};
        int W = 8;
        int n = val.length;
        int profit = knapsack(wt, val, W, n);
        System.out.println("Max profit is: " + profit);

    }

    public static int knapsack(int[] wt, int[] val, int W, int n){
        if(n==0 || W==0){
            return 0;
        }

        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapsack(wt, val, W-wt[n-1], n-1), knapsack(wt, val, W, n-1));
        }
        else {
            return knapsack(wt, val, W, n-1);
        }
    }
}
