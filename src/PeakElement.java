import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeakElement {
    public static int findPeak(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && ((mid == n - 1) || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }
            if ((mid + 1 <= n - 1) && (arr[mid + 1] > arr[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(findPeak(arr));
    }
}
