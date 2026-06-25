//Given a rod of length n and an array price[]. price[i] denotes the price of a piece of length i. Determine the maximum amount obtained by cutting the rod into pieces and selling the pieces.
//
//Note: price[0] is always 0.
//
//Input: price[] =  [0, 1, 5, 8, 9, 10, 17, 17, 20]
//Output: 22
//Explanation:  The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
//
//Input : price[] =  [0, 3, 5, 8, 9, 10, 17, 17, 20]
//Output : 24
//Explanation : The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.
//
//Input : price[] =  [0, 3]
//Output : 3
//Explanation: There is only 1 way to pick a piece of length 1.

public class Problem7RodCuttingToMaxProfit {
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int wt[] = {1,2,3,4,5,6,7,8};
        int len = price.length;
        int result = knapsack(price, len, wt);
        System.out.println("Maximum obtainable value is: " + result);
    }

    public static int knapsack(int[] price, int len, int[] wt){
        int dp[][] = new int[len+1][len+1];
        //initialise first row and column
        for(int i=0;i<len+1;i++){
            for(int j=0;j<len+1;j++){
                if(i==0)
                    dp[i][j] = 0;
                if(j==0)
                    dp[i][j] = 0;
            }
        }

        //initialise remaining matrix
        for(int i=1;i<len+1;i++){
            for(int j=1;j<len+1;j++){
                if(wt[i-1]<=j)
                    dp[i][j] = Math.max(price[i-1] + dp[i][j- wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len][len];
    }
}
