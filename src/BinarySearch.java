/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Name of the class has to be "Main" only if the class is public. */
public class BinarySearch
{
    public static int getIndexOf(int[] arr, int k){
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        int[] ipArray = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            ipArray[i] = Integer.parseInt(s[i]);
        }

        int T = Integer.parseInt(br.readLine().strip());
        while(T>=1){
            int k = Integer.parseInt(br.readLine().strip());
            System.out.println(getIndexOf(ipArray, k));
            T--;
        }
    }
}