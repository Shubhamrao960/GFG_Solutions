//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
     class Pair{
         int first;
         int second;
         Pair(int first,int second){
             this.first=first;
             this.second=second;
         }
     }
     private void topo(ArrayList<ArrayList<Pair>> adj,Stack<Integer> st,int i,int[] vis){
         vis[i]=1;
         for(Pair it: adj.get(i)){
             if(vis[it.first]==0){
                 topo(adj,st,it.first,vis);
             }
         }
         st.push(i);
     }
    public int[] shortestPath(int v, int e, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int x=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(x,w));
        }
        int [] vis =new int[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if (vis[i]==0){
              topo(adj,st,i,vis);
            }
        }
        int []dist =new int[v];
        for(int i=0;i<v;i++){
            dist[i]=(int)(1e9);
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            for(Pair it: adj.get(node)){
                int x=it.first;
                int w=it.second;
                if(dist[node]+w<dist[x]){
                    dist[x]=dist[node]+w;
                }
            }
        }
        for(int i=0;i<v;i++){
            if(dist[i]==(int)(1e9)){
                dist[i]=-1;
            }
        }
        return dist;
    }
}