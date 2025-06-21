// User function Template for Java

class Solution {
    public static int maxProfit(int val[], int wt[], int capacity, int inx ,int[][]dp ){
        if(inx<0) return 0;
        if(dp[inx][capacity]!=-1) return dp[inx][capacity];
        int notTake=maxProfit(val,wt,capacity,inx-1,dp);
        int take=0;
        if(capacity>=wt[inx]){
            take=val[inx]+maxProfit(val,wt,capacity-wt[inx],inx,dp);
        }
        dp[inx][capacity]=Math.max(notTake,take);
        return dp[inx][capacity];
    }
    
    static int knapSack(int val[], int wt[], int capacity) {
        int n=val.length;
        int [][]dp=new int [n][capacity+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return maxProfit(val,wt,capacity,n-1,dp);
        
    }
}