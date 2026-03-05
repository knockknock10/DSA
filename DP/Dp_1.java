package DP;
import java.util.Arrays;
import java.util.HashSet;
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
    //largest common subseqence
    public static int lcs(String str1,String str2,int n,int m){
        if(n==0 ||m ==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){//same
            return lcs(str1, str2, n-1, m-1)+1;
        }else{ //diff
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }
    public static int lcsmemo(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m] =  lcsmemo(str1, str2, n-1, m-1, dp)+1;
        }else{
            int ans1 = lcsmemo(str1, str2, n-1, m, dp);
            int ans2 = lcsmemo(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }
    public static int lcsTab(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
        
    }
    //TC O(n*m)
    public static int longestCommonSubstr(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        
        //initialize
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] =0;
        }
        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
        
    } 
    public static int lics(int arr[],int arr2[]){
        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }
        
        for(int i =1;i<n+1;i++){
            for(int j= 1;j<m+1;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }return dp[n][m];
    }
    public static int Lis(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        
        int arr2[] = new int[set.size()];//sorted unique els
        int i = 0;
        for(int num:set){
            arr2[i] = num;
            i++;
        }
        
        Arrays.sort(arr2);
        return lics(arr,arr2);
    }
    //Edit Distance TC O(n*m)
    public static int editDistance(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        
        //intialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }
        //bottom up 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1]+1;
                    int del = dp[i-1][j]+1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add, Math.min(del, replace));
                }
            }
        }return dp[n][m];
    }
    public static int string_con(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][m];
        int add = n-lcs;
        int del= m-lcs;
        return add+del;
    }
    //wildcard pattern matching
    //Hard Tc O(n*m)
    public static boolean isMatch(String s, String p){
        int n = s.length();
        int m = p.length();
        
        boolean dp[][] = new boolean[n+1][m+1];
        
        //intialize
        dp[0][0] = true;
        //pattern = " "
        for(int i=1;i<n+1;i++){
            dp[i][0] = false;
        }
        //s = ""
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }//ehere by default otehre are false so no else condition
        }
        
        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case ->ith char == jth char || jth char == ?
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        //string ->n,pattern -> m
        return dp[n][m];
        
    }
    //Catalan's Number 
    public static int catalansRec(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans = 0; //cn
        for(int i=0;i<=n-1;i++){
            ans+=catalansRec(i)*catalansRec(n-i-1);
        }
        return ans;
    }
    //Memoization
    public static int catalanMemo(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=catalanMemo(i, dp)*catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    public  static int catalanTab(int n){
        int dp[] = new int[n+1];
        dp[0]  = 1;
        dp[1]=  1;
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];//Ci = Cj*ci-j-1
            }
        }
        return dp[n];
    }
    //Count the trees
    public static int countBst(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                //Ci = Cj * Ci-j-1
                //dp[i] = dp[j] * dp[i-j-1];
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left*right;
            }
        }
        return dp[n];
        
    }
    //Mountain Ranges TC O(n^2)
    public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2;i<n+1;i++){
            //i pairs ->mountains ranges => Ci
            for(int j=0;j<i;j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i]+= inside*outside;//Ci = Cj*Ci-j-1
            }
        }
        return dp[n];
    }
    //Matrix chain multiplication
    public static int mcm(int arr[],int i,int j){
        if(i==j){
            return 0; //single matrix
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1 = mcm(arr, i, k); //Ai ...Ak =>arr[i-1]arr[k]
            int cost2 = mcm(arr, k+1, j);//Ai+1...Aj =>arr[k]xarr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }
    //Matrix chain Multiplication memoization
    public static int mcmmemo(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcmmemo(arr, i, k, dp);
            int cost2 = mcmmemo(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, cost1+cost2+cost3);
        }
        return dp[i][j] = ans;
    }
    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        
        //intitalization
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        //bottom up
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j = i+len-1;//col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        printdptab(dp);
        return dp[1][n-1];
    }
    public static void printdptab(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }System.out.println();
        }
    }
        //Minium partiting TC O(w*n)
        public static int minPartition(int arr[]){
            int n = arr.length;
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
            }
            int W = sum/2;
            
            int dp[][] = new int[n+1][W+1];
            
            //bottom up
            for(int i=1;i<n+1;i++){
                for(int j=1;j<W+1;j++){
                    if(arr[i-1]<=j){//valid
                        //include
                        dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]], dp[i-1][j]);
                    }else{//invalid
                        dp[i][j] = dp[i-1][j];    
                    }
                }
            }
            int sum1 = dp[n][W];
            int sum2 = sum - sum1;
            return Math.abs(sum1-sum2);
        }
        //Min array jumps tabulation
        public static int minJumps(int nums[]){
            int n = nums.length;
            int dp[] = new int[n];
            Arrays.fill(dp,-1);
            dp[n-1] = 0;
            
            for(int i=n-2;i>=0;i--){
                int steps = nums[i];
                int ans = Integer.MAX_VALUE;
                for(int j=i+1;j<=i+steps && j<n ;j++){
                    if(dp[j]!=-1){
                        ans = Math.min(ans, dp[j]+1);
                    }
                }
                if(ans!=Integer.MAX_VALUE){
                    dp[i] = ans;
                }
            }
            return dp[0];
        }
        //segment Tree
        //Construct TC O(n)
        static int tree[];
        public static void init(int n){
            tree = new int[4*n];
            
        }
        public static int builST(int arr[],int i,int start,int end){
            if(start==end){ //leaf nodes
                tree[i] = arr[start];
                return arr[start];
            }
            int mid = (start+end)/2;
            builST(arr, 2*i+1, start, mid);//left subtree -2*i+1
            builST(arr, 2*i+2, mid+1, end);//right subtree -2*i+2
            tree[i] = tree[2*i+1] + tree[2*i+2];
            return tree[i];
        }
        public static int getsumUtil(int i,int si,int sj,int qi,int qj){
            if(qj<=si || qi>=sj){//non overlapping
                return 0;    
            }else if(si>=qi && sj<=qj){//complete overlap
                return tree[i];    
            }else{//partial overlap
                int mid = (si+sj)/2;
                int left = getsumUtil(2*i+1, si, mid, qi, qj);
                int right = getsumUtil(2*i+2, mid+1, sj, qi, qj);
                return left+right;               
            }
        }
        public static int getsum(int arr[],int qi,int qj){
            int n = arr.length;
            return getsumUtil(0, 0, n-1, qi, qj);
        }
        public static void updateUtil(int i,int si,int sj,int idx,int diff){//logn
            if(idx>sj || idx <si){
                return;
            }
            tree[i]+=diff;
            if(si!=sj){//non-leaf
                int mid = (si+sj)/2;
                updateUtil(2*i+1, si, mid, idx, diff);//left
                updateUtil(2*i+2, mid+1, sj, idx, diff);    //right
            }
        }
        public static void update(int arr[],int idx,int newval){
            int n = arr.length;//O(n)
            int diff = newval-arr[idx];
            arr[idx] = newval;
            
            updateUtil(0, 0, n-1, idx, diff);
        }
        //Maxium element quires
        public static void inits(int n){
            tree = new int[4*n];
            
        }
        public static void buildTree(int i,int si,int sj,int arr[]){//O(n)
            if(si==sj){
                tree[i] = arr[si];
                return;
            }
            int mid = (si+sj)/2;//si+(sj-si)/2
            buildTree(2*i+1, si, mid, arr);
            buildTree(2*i+2, mid+1, sj, arr);
            
            tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        }
        public static int getmax(int arr[],int qi,int qj){
            int n = arr.length;
            return getmaxutil(0,0,n-1,qi,qj);
        }
        public static int getmaxutil(int i,int si,int sj,int qi,int qj){
            if(si>qj || sj<qi){//no overlap
                return Integer.MIN_VALUE;
            }else if(si>=qi && sj<=qj){
                return tree[i];
            }else{//partial overlap
                int mid = (si+sj)/2;
                int leftAns = getmaxutil(2*i+1, si, mid, qi, qj);
                int rightAns = getmaxutil(2*i+2, mid+1, sj, qi, qj);
                return Math.max(leftAns, rightAns);
            }
        }
        //update
        public static void updates(int arr[],int idx,int newVal){///o(logn)
            arr[idx] = newVal;
            int n = arr.length;
            updateUtils(0, 0, n-1, idx, newVal);
        }
        //update that segment tree
        public static void updateUtils(int i,int si,int sj,int idx,int newVal){
            if(idx<si || idx>sj){
                return;
            }
            if(si == sj){
                tree[i] = newVal;
            }
            if(si!=sj){
                tree[i] = Math.max(tree[i], newVal);
                int mid = (si+sj)/2;
                updateUtils(2*i+1, si, mid, idx, newVal);//left 
                updateUtils(2*i+2, mid+1, sj, idx, newVal);
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
        // System.out.println(UnboundedKnapsack(val,wt,W));
        // int W = 7;
        //int coins[] = {1,2,3};
        //int sum = 4; //ans = 4;
        // int coins[] = {2,5,3,6};
        // int sum = 10;
        
        // System.out.println(coinChange(coins, sum));
        // int length[] = {1,2,3,4,5,6,7,8};
        // int price[] = {1,5,8,9,10,17,17,20};
        // int rodLength = 8;
        // System.out.println(RodCutting(length, price, rodLength));
        // String str1 = "abcdge";
        // String str2 = "abedg";//lcs = "abdg";length = 4
        // System.out.println(lcs(str1, str2, str1.length(),str2.length()));
        // int n = str1.length();
        // int m = str2.length();
        // int dp[][] = new int[n+1][m+1];
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(lcsmemo(str1, str2,str1.length(),str2.length(), dp));   
        // System.out.println(lcsTab(str1, str2));
       // System.out.println(longestCommonSubstr(str1, str2));
        // int arr[]={50,3,0,7,40,80};
        // System.out.println(Lis(arr)); 
        // String word1 = "intention";
        // String word2 = "execution";
        // System.out.println(editDistance(word1, word2));  
        // String str1 = "abcdefg";
        // String str2 = "bcdg";
        // System.out.println(string_con(str1, str2)); 
        // String s = "baaabab";
        // String p = "*****ba*****ab";
        // System.out.println(isMatch(s, p));  
        //int n = 4; 
        //System.out.println(catalansRec(n));
        //int dp[] = new int[n+1];
        //Arrays.fill(dp,-1);
        //System.out.println(catalanMemo(n, dp));
        //System.out.println(catalanTab(n));
        //int n = 4;
        //System.out.println(countBst(n));
        //System.out.println(mountainRanges(n));
        //int arr[] = {1,2,3,4,3};
        //int n = arr.length;
        // System.out.println(mcm(arr, 1, n-1));
        //int dp[][] = new int[n][n];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println(mcmmemo(arr, 1 ,n-1, dp));
        //System.out.println(mcmTab(arr));
        // int num[] = {1,6,11,5};
        // System.out.println(minPartition(num));
        // int nums[] = {2,3,1,1,4};
        // System.out.println(minJumps(nums));
        // int arr[] = {1,2,3,4,5,6,7,8};
        // int n = arr.length;
        // init(n);
        // builST(arr, 0, 0, n-1);
        // // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }
        // System.out.println(getsum(arr, 2, 5));//18
        // update(arr, 2, 2);
        // System.out.println(getsum(arr, 2, 5));//17
      int arr[] = {6,8,-1,2,17,1,3,2,4};
      int n = arr.length;
      inits(n);
      buildTree(0, 0, n-1, arr);
    //   for(int i=0;i<tree.length;i++){
    //     System.out.print(tree[i]+" ");
    //   }
        int max = getmax(arr, 2, 5);
        System.out.println(max);
        updates(arr, 2, 20);
        max = getmax(arr, 2, 5);
        System.out.println(max);//20
        //take the while loop while({qi,qj})
    }
    
}