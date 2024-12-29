//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    class DisjointSet{
        ArrayList<Integer> parent=new ArrayList<>();
        ArrayList<Integer> rank=new ArrayList<>();
        ArrayList<Integer> size=new ArrayList<>();
        public DisjointSet(int n) {
            for(int i = 0;i<=n;i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }
        public int Find_U_Parent(int node){
            if(parent.get(node)==node){
                return node;
            }
            int ULP=Find_U_Parent(parent.get(node));
            parent.set(node,ULP);
            return ULP;
            
        }
        public void UnionByRank(int u,int v){
            int ulp_u=Find_U_Parent(u);
            int ulp_v=Find_U_Parent(v);
            if(Find_U_Parent(u)==Find_U_Parent(v)){
                return;
            }
            if(rank.get(ulp_u)<rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }else if(rank.get(ulp_u)>rank.get(ulp_v)){
                parent.set(ulp_v, ulp_u);
            }else{
                parent.set(ulp_v, ulp_u);
                int rankU=rank.get(ulp_u);
                rank.set(ulp_u,rankU+1);
            }
        }
        public void UnionBySize(int u,int v){
            int ulp_u=Find_U_Parent(u);
            int ulp_v=Find_U_Parent(v);
            if(Find_U_Parent(u)==Find_U_Parent(v)){
                return;
            }
            if(size.get(ulp_u)<rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }
        }
        
    }
    
     int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
       DisjointSet ds=new DisjointSet(V);
       for(int i=0;i<V;i++){
           for(int j=0;j<V;j++){
               if(adj.get(i).get(j)==1){
                   ds.UnionBySize(i,j);
               }
           }
       }
       int cnt=0;
       for(int i=0;i<V;i++){
           if(ds.parent.get(i)==i) cnt++;
       }
       return cnt;
       
    }
};