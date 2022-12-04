//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean canStallAccomodateCows(int[] stalls, int n, int d, int cows) {
        int count = 1, prev = stalls[0];
        for (int i = 1; i < n; i++) {
          if (stalls[i] - prev < d) {
            continue;
          }
          count++;
          prev = stalls[i];
        }
        return count >= cows;
    }
    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canStallAccomodateCows(stalls, n, mid, cows)) {
              if (!canStallAccomodateCows(stalls, n, mid + 1, cows)) {
                return mid;
              }
              low = mid + 1;
            } else {
              high = mid - 1;
            }
        }
        return -1;
    }
}