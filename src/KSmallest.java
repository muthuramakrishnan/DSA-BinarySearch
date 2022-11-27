import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KSmallest {
  public static int findSmallerElemCount(int[] arr, int k) {
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] <= k) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    // find kth smallest element
    // Not worried about time complexity
    // but the original array should not be tampered & no new array should be created

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int k = Integer.parseInt(br.readLine().strip());
    int n = str.length;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }

    for (int i = 0; i < n; i++) {
      int smallElCount = findSmallerElemCount(arr, arr[i]);
      if (smallElCount >= k) {
        // could be a possible ans
        if (findSmallerElemCount(arr, arr[i] - 1) < k) {
          System.out.println(arr[i]);
          System.exit(0);
        }
      }
    }
  }
}
