import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleElement {
    public static boolean isFirstOccurence(int[] arr, int idx) {
        return arr[idx + 1] == arr[idx];
    }

    public static int getSingleElement(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] != arr[mid]) && (mid == n - 1 || arr[mid + 1] != arr[mid])) {
                return arr[mid];
            } else if ((mid % 2 == 0 && isFirstOccurence(arr, mid)) || (mid % 2 != 0 && !isFirstOccurence(arr, mid))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        if (n % 2 == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(getSingleElement(arr));
    }
}
