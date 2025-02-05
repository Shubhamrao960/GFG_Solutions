//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        int one=0;
        int two=0;
        int tht=num;
        if((num &(1<<i-1))!=0) one=1;
        if(one==0){
           two = (num|( 1<<i-1));
        }else two =num;
        
         if(one!=0){
             tht=num&(~(1<<i-1));
        }
       System.out.print(one+" "+two+" "+tht);
    }
}
