import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindElementAtSomePositionMatrix {
  public static int findCountOfMinEle(int[][] arr, int k) {
    int m = arr.length;
    int n = arr[0].length;
    int total = 0;
    for (int i = 0; i < m; i++) {
      int low = 0, high = n - 1;
      int count = 0;
      while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[i][mid] > k && (mid == 0 || arr[i][mid - 1] <= k)) {
          count = mid;
          break;
        }
        if (arr[i][mid] > k) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      total += count == 0 ? n : count;
    }
    return total;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m, n, k;
    m = Integer.parseInt(br.readLine().strip());
    n = Integer.parseInt(br.readLine().strip());

    int[][] arr = new int[m][n];
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      String[] s = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(s[j]);
        low = Math.min(low, arr[i][j]);
        high = Math.max(high, arr[i][j]);
      }
    }

    k = Integer.parseInt(br.readLine().strip());
    while (low <= high) {
      int mid = (low + high) / 2;
      int mCount = findCountOfMinEle(arr, mid);
      if (mCount < k) {
        low = mid + 1;
      } else {
        int mCountMinusOne = findCountOfMinEle(arr, mid - 1);
        if (mCountMinusOne < k) {
          System.out.println(mid);
          System.exit(0);
        } else {
          high = mid - 1;
        }
      }
    }
  }
}
