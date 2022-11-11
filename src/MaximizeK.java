import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximizeK {
  public static boolean checkIsValidSubArr(int[] arr, int subArraySize, int x) {
    int sum = 0;
    for (int i = 0; i < subArraySize; i++) {
      sum += arr[i];
    }

    int i = subArraySize;
    while (i < arr.length) {
      if (sum > x) {
        return false;
      }
      sum += arr[i];
      sum -= arr[i - subArraySize];
      i++;
    }
    if (sum > x) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = s.length;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }
    int x = Integer.parseInt(br.readLine().strip());

    int low = 1, high = n;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (!checkIsValidSubArr(arr, mid, x)) {
        high = mid - 1;
      } else {
        if (checkIsValidSubArr(arr, mid + 1, x)) {
          low = mid + 1;
        } else {
          System.out.println(mid);
          System.exit(0);
        }
      }
    }
  }
}
