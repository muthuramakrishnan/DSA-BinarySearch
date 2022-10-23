import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortedRotatedArray {
    public static int binarySearch(int[] arr, int low, int high, int k) {
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findIndexOf(int[] arr, int k) {
        //find the pivot
        int n = arr.length, low = 0, high = n - 1, pivot = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[n - 1] && (mid > 0 ? arr[mid] > arr[mid - 1] : true) && (mid + 1 <= n - 1 ? arr[mid] > arr[mid + 1] : true)) {
                pivot = mid;
                break;
            } else if (arr[mid] < arr[n - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (n == 1) {
            return binarySearch(arr, 0, 0, k);
        }
        return k > arr[n - 1] ? binarySearch(arr, 0, pivot, k) : binarySearch(arr, pivot + 1, n - 1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int k = Integer.parseInt(br.readLine().strip());
        int res = findIndexOf(arr, k);
        System.out.println(res);
    }
}
