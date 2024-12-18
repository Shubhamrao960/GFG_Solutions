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
    
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
    
      
    int [] indeg=new int[v];
    for(int i=0;i<=v-1;i++){
        for(int it:adj.get(i)){
            indeg[it]++;
        }
    }
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<v;i++){
        if(indeg[i]==0){
           q.add(i) ;
        }
    }
    ArrayList<Integer> topo=new ArrayList<>();
    int k=0;
    while(!q.isEmpty()){
        int node=q.peek();
        q.remove();
        for(int it:adj.get(node)){
            indeg[it]--;
            if(indeg[it]==0){
                q.add(it);
            }
        }
        topo.add(node);
    }
    if(topo.size()==v) return false;
    return true;
    }
}