import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KSmallestBinarySearch {
  public static int findMinElCounts(int[] arr, int k) {
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] <= k) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");

    int n = s.length;
    int[] arr = new int[n];
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(s[i]);
      low = Math.min(low, arr[i]);
      high = Math.max(high, arr[i]);
    }

    int k = Integer.parseInt(br.readLine().strip());

    while (low <= high) {
      int mid = (low + high) / 2;
      int count = findMinElCounts(arr, mid);
      if (count >= k) {
        if (findMinElCounts(arr, mid-1) < k) {
          System.out.println(mid);
          System.exit(0);
        } else {
          high = mid - 1;
        }
      } else {
        low = mid + 1;
      }
    }
  }
}
