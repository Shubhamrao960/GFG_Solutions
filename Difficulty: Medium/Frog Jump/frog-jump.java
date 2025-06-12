
class Solution {
    
    private int fun(int n,int [] arr,int [] height){
        if(n==0)return 0;
        
        int left;
        if(arr[n]==-1){
             left=fun(n-1,arr,height)+Math.abs(height[n-1]-height[n]);
        }else left=arr[n];
        int right;
        if(n==1) return left;
        if(arr[n]==-1){
              right=fun(n-2,arr,height)+Math.abs(height[n-2]-height[n]);
        }else right=arr[n];
        
        int min=Math.min(left,right);
        arr[n]=min;
        return min;
        
    }
    int minCost(int[] height) {
        int n=height.length;
       int [] arr=new int[height.length];
       for(int i=0;i<height.length;i++){
           arr[i]=-1;
       }
       return fun(height.length-1,arr,height);
        
    }
}