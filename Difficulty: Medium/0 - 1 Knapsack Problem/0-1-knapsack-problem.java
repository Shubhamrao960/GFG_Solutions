class Solution {
    
    public static int memo(int n,int wt[],int []val,int W,int[][]dp){
        if(n==0){
            if(W>=wt[0]) return val[0];
            return 0;
        }
        if(W==0) return 0;
        if(dp[n][W]!=-1) return dp[n][W]; 
        
        int notTake=memo(n-1,wt,val,W,dp);
        int take=0;
        if(W>=wt[n]){
            take=val[n]+memo(n-1,wt,val,W-wt[n],dp);
        }
        dp[n][W]=Math.max(notTake,take);
        return Math.max(notTake,take);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        int [][]dp=new int[n][W+1];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        return memo(n-1,wt,val,W,dp);
        
    }
}
