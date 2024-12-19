//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
   
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
             int v=adj.size();
              int [] vis =new int[v];
            Queue<Integer> q =new LinkedList<>();
            q.add(src);
            vis[src]=1;
            int [] dist=new int[v];
            for(int i=0;i<v;i++){
                dist[i]=(int)(1e9);
            }
            dist[src]=0;
            while(!q.isEmpty()){
                int node=q.peek();
                q.remove();
                for(int it:adj.get(node)){
                    if(dist[it]>dist[node]+1){
                        dist[it]=dist[node]+1;
                    }
                    if(vis[it]==0){
                        vis[it]=1;
                        q.add(it);
                        
                    }
                }
            }
            for(int i=0;i<v;i++){
                if(dist[i]==(int)1e9){
                    dist[i]=-1;
                }
            }
            return dist;
    }
}
