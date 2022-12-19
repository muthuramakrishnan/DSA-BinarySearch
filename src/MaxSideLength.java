import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// This is a bruteForce approach
public class MaxSideLength {
  public static boolean isSubArrLessOrEqualToThreshold(int[][] arr, int arrSize, int threshold) {
    int sum = 0;

    for (int i = 0; i < arrSize; i++) {
      for (int j = 0; j < arrSize; j++) {
        sum += arr[i][j];
      }
    }
    return sum <= threshold;
  }

  public static void main(String[] args) throws IOException {
    int m, n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    m = Integer.parseInt(br.readLine().strip());
    n = Integer.parseInt(br.readLine().strip());

    int[][] arr = new int[m][n];
    for (int i = 0; i < m; i++) {
      String[] tempString = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(tempString[j]);
      }
    }

    int threshold = Integer.parseInt(br.readLine().strip());
    int maxArrSize = Math.min(m, n);
    int arrSize;
    for (arrSize = 1; arrSize <= maxArrSize; arrSize++) {
      if (!isSubArrLessOrEqualToThreshold(arr, arrSize, threshold)) {
        System.out.println(arrSize - 1);
        System.exit(0);
      } else {
        continue;
      }
    }
    if (isSubArrLessOrEqualToThreshold(arr, arrSize, threshold)) {
      System.out.println(arrSize - 1);
    } else {
      System.out.println(-1);
    }
  }
}
