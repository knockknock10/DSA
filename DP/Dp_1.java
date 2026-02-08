package DP;
import java.util.Arrays;
public class Dp_1{
    //fibonacii by memoization
    public static int fib(int n,int f[]){
        if(n==1 || n==0){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = fib(n-1, f)+fib(n-2, f);
        return f[n];
    }
    //fibonacii by dp
    public static int fibs(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    
    }
    //Climbing Stairs  T.C O(2^n)
    public static int countways(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return countways(n-1)+countways(n-2);
    }
    //Climbing stairs memoization  TC O(n)
    public static int countwaysmemo(int n,int ways[]){
        
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){  //already calc
            return ways[n];
        }
        ways[n] = countwaysmemo(n-1,ways)+countwaysmemo(n-2,ways);
        return ways[n];
    }
    public static int countwaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
    //0-1 knapsack Recursion
    public static int knapsack(int val[],int wt[],int W,int n){
        if(W==0 || n==0){
            return 0;
        }
        if(wt[n-1] <= W){
            //include
            int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        }else{
            return knapsack(val, wt, W, n-1);
        }
    }
    // 0-1 knapsack by memoization   TC O(nW)
    public static int knapsackmemo(int val[],int wt[],int W,int n,int dp[][]){
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            //include
            int ans1 = val[n-1]+knapsackmemo(val, wt, W-wt[n-1], n-1,dp);
            //exclude
            int ans2 = knapsackmemo(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = knapsackmemo(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }System.out.println();
        }System.out.println();
    }
    public static int knapsackTab(int val[],int wt[],int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){//oth col intialize
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){ //oth row
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];//ith item value
                int w = wt[i-1];//ith item wt
                if(w<=j){//valid
                    int incProfit = v+dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{//invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }
    //Target Sum Subset TC O(n*sum)
    public static boolean targetSumSubset(int arr[],int  sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        //i=items and j = target sum
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v]== true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        printsu(dp);
        return dp[n][sum];
    }
    public static void printsu(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }System.out.println();
        }System.out.println();
    }
    //TC O(n*w)  Unbounded Knapsack
    public static int UnboundedKnapsack(int val[],int wt[],int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        
        for(int i=0;i<n+1;i++){  //this not necc by default in java there would be 0 
            dp[i][0] = 0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){//valid
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    //coin change problem  tc O(n*sum)
    public static int coinChange(int coins[],int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        
        //intializing -sum is 0
        //i-> couns j-> sum/change
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<sum+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    //Rod cutting probelm TC O(n*tot)
    //wight = length val = price W = totRod
    public static int RodCutting(int length[],int price[],int tot){
        int n = length.length;
        int dp[][] = new int[n+1][tot+1];
        //by default ther eis initializaton of 0 
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<tot+1;j++){
        //         if(i==0 || j==0){
        //             dp[i][j] = 0;
        //         }
        //     }
        // }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<tot+1;j++){
                if(length[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }else{
                    //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][tot];
    }
    public static void main(String[] args) {
        // int n = 5;
        // int f[] = new int[n+1];
        // int ways[] = new int[n+1];
        // Arrays.fill(ways,-1);
        // System.out.println(fib(n, f));
        // System.out.println(fibs(n));
        // System.out.println(countways(n));
        // System.out.println(countwaysmemo(n,ways));
        // System.out.println(countwaysTab(n));
        // int val[] = {15,14,10,45,30};
        // int wt[] = {2,5,1,3,4};
        // int W = 7;
        // int no = val.length;
        // System.out.println(knapsack(val, wt, W, no));
        // int dp[][] = new int[no+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapsackmemo(val, wt, W, no, dp));
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }System.out.println();
        // }System.out.println();
        //System.out.println(knapsackTab(val, wt, W));
        // int arr[] = {4,2,7,1,3};
        // int sum = 10;
        // System.out.println(targetSumSubset(arr, sum));
        // int val[] = {15,14,10,45,30};
        // int wt[] = {2,5,1,3,4};
        // int W = 7;
        // System.out.println(UnboundedKnapsack(val,wt,W));
        //int coins[] = {1,2,3};
        //int sum = 4; //ans = 4;
        // int coins[] = {2,5,3,6};
        // int sum = 10;
        
        // System.out.println(coinChange(coins, sum));
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        System.out.println(RodCutting(length, price, rodLength));
    }
}