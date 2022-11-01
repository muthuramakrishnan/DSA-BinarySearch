import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindElementAtSomePosition {
    public static int findCountOfSmallerEle(int[] arr, int k) {
        int count = 0;
        for (int j : arr) {
            if (j <= k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int k = Integer.parseInt(br.readLine().strip());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (high + low) / 2;
            int mCount = findCountOfSmallerEle(arr, mid);
            if (mCount < k) {
                low = mid + 1;
            } else {
                int mMinusOneCount = findCountOfSmallerEle(arr, mid - 1);
                if (mMinusOneCount < k) {
                    System.out.println(mid);
                    System.exit(0);
                } else {
                    high = mid - 1;
                }
            }
        }
    }
}
