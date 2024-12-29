//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


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

    public int Solve(int n, int[][] edge) {
        int m=edge.length;
       DisjointSet ds=new DisjointSet(n);
       for(int i=0;i<m;i++){
           int u=edge[i][0];
           int v=edge[i][1];
             ds.UnionBySize(u,v) ; 
       }
       int cnt=0;
       for(int i=0;i<n;i++){
           if(ds.parent.get(i)==i) cnt++;
       }
       int req_Node=cnt-1;
       if(m<n-1){
           return -1;
       }else 
       return cnt-1;
       
    }
}
