import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CowsProblem {
  public static boolean canStallAccomodateCows(int[] stalls, int n, int d, int cows) {
    int count = 0, prev = stalls[0];
    for (int i = 1; i < n; i++) {
      if (stalls[i] - prev < d) {
        continue;
      }
      count++;
      prev = stalls[i];
    }
    return count >= cows;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().strip());

    while (T >= 1) {
      String[] s = br.readLine().split(" ");
      int n = Integer.parseInt(s[0]);
      int cows = Integer.parseInt(s[1]);

      int[] stalls = new int[n];
      s = br.readLine().split(" ");

      for (int i = 0; i < n; i++) {
        stalls[i] = Integer.parseInt(s[i]);
      }
      Arrays.sort(stalls);
      int low = 1, high = stalls[n - 1] - stalls[0];
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (canStallAccomodateCows(stalls, n, mid, cows)) {
          if (!canStallAccomodateCows(stalls, n, mid + 1, cows)) {
            System.out.println(mid);
            break;
          }
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      T--;
    }
  }
}
