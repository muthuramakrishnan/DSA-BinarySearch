import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatedElement {
    public static int findRepeatedElement(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == mid) {
                high = mid - 1;
            } else if (mid + 1 <= n - 1 && arr[mid] == mid + 1) {
                if (arr[mid] == arr[mid + 1]) {
                    return arr[mid];
                } else {
                    low = mid + 1;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(findRepeatedElement(arr));
    }
}
