package DP;

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
    //Climbing Stairs
    public static int countways(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return countways(n-1)+countways(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n+1];
        System.out.println(fib(n, f));
        System.out.println(fibs(n));
        System.out.println(countways(n));
    }
}