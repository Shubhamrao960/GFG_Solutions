// User function Template for Java

class Solution {
    
    public int maxPoint(int n,int[][] arr,int [][]dp,int last){
        if(n==0){
            int max=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                max=Math.max(max,arr[0][i]);
            }
        }
        return max;
        }
        if(dp[n][last]!=-1) return dp[n][last];
        int max=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                
                max=Math.max(max,arr[n][i]+maxPoint(n-1,arr,dp,i));
    
            }
        }
        dp[n][last]=max;
        return max;
    }
    public int maximumPoints(int arr[][]) {
      int [][] dp=new int[arr.length][arr[0].length+1];  
     for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxPoint(arr.length-1,arr,dp,3);

        
    }
}