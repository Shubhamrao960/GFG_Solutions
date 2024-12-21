//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<iPair>>adj=new ArrayList<ArrayList<iPair>>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<iPair>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new iPair(v,w));
            adj.get(v).add(new iPair(u,w));
        }
       
        
         PriorityQueue<iPair> pq =new PriorityQueue<>((x, y)->x.second-y.second);
            int []dist= new int[n+1];
            int v=n+1;
             int [] parent=new int[v];
            for(int i=0;i<v;i++){
                dist[i]=(int)1e9;
                 parent[i]=1;
            }
            int src=1;
            dist[src]=0;
            pq.add(new iPair(src,0));
            while(!pq.isEmpty()){
                int ds=pq.peek().second;
                int node=pq.peek().first;
                pq.remove();

                for( int it=0;it<adj.get(node).size();it++){
                    int edgewt=adj.get(node).get(it).second;
                    int adjNode=adj.get(node).get(it).first;
                    if(ds+edgewt<dist[adjNode]){
                        dist[adjNode]=ds+edgewt;
                        pq.add(new iPair(adjNode,dist[adjNode]));
                        parent[adjNode]=node;
                    }
                }
            }
            int node=n;
           ArrayList<Integer> path=new ArrayList<>();
           if(dist[n]==1e9){
               path.add(-1);
           }else{
            while(node!= parent[node]){
                path.add(node);
                 node=parent[node];
            }
            path.add(1);
            path.add(dist[n]);
            Collections.reverse(path);
           }
             return path;  
           
    }
}