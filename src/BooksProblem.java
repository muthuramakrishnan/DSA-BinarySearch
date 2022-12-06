import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooksProblem {
  public static boolean isAllocationPossible(int[] arr, int n, int mid, int m) {
    int allotedChildren = 1, allotedPages = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] + allotedPages > mid) {
        allotedChildren++;
        allotedPages = arr[i];
      } else {
        allotedPages += arr[i];
      }
    }
    return allotedChildren <= m;
  }

  public static int findPages(int[] arr, int n, int m) {
    // Your code here
    if (m > n) {
      return -1;
    }
    int low = Integer.MIN_VALUE, high = 0;
    for (int i = 0; i < n; i++) {
      low = Math.max(arr[i], low);
      high += arr[i];
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (isAllocationPossible(arr, n, mid, m)) {
        if (!isAllocationPossible(arr, n, mid - 1, m)) {
          return mid;
        } else {
          high = mid - 1;
        }
      } else {
        low = mid + 1;
      }
    }
    if (isAllocationPossible(arr, n, low, m)) {
      return low;
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().strip());
    String[] s = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }
    int m = Integer.parseInt(br.readLine().strip());
    System.out.println(findPages(arr, n, m));
  }
}
