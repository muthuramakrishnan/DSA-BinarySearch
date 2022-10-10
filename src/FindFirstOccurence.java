import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFirstOccurence {
    public static int getFirstOccurrenceOf(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0 || (arr[mid] == k && arr[mid - 1] != k)) {
                return mid + 1;
            } else if (arr[mid] == k || arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(getFirstOccurrenceOf(arr, k));
    }
}
