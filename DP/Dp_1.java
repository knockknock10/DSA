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
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int no = val.length;
        System.out.println(knapsack(val, wt, W, no));
        
    }
}