/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Name of the class has to be "Main" only if the class is public. */
public class FindFrequency
{
    public static int getFrequency(int[] arr, int k){
        int startIdx=-1, endIdx=-1;
        int n = arr.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid = (high+low)/2;
            if (arr[mid] == k && (mid==0 || arr[mid - 1] != k)){
                startIdx=mid;
                break;
            }
            else if(arr[mid]>=k){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }

        low =0;
        high = n-1;
        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid] == k && (mid==n-1 || arr[mid+1]!=k)){
                endIdx=mid;
                break;
            }
            else if(arr[mid]<=k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return endIdx == -1 ? 0 : endIdx-startIdx+1;
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
            System.out.println(getFrequency(ipArray, k));
            T--;
        }
    }
}