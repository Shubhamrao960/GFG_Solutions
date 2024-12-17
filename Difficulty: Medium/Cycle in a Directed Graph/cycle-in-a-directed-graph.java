//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    private boolean cycle(int node,int v,ArrayList<ArrayList<Integer>> adj,int []vis,int []pathvis){
        vis[node]=1;
        pathvis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(cycle(it,v,adj,vis,pathvis)==true){
                    return true;
                }
            }else if(vis[it]==1&&pathvis[it]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int [] vis=new int [v];
        int [] pathvis=new int[v];
        for(int i=0;i<=v-1;i++){
            if(vis[i]==0){
                if(cycle(i,v,adj,vis,pathvis)==true){
                    return true;
                }
            }
        }
        return false;
    }
}