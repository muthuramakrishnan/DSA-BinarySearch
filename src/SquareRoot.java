import java.util.Scanner;

public class SquareRoot {
    public static int findSqrt(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == n || (mid * mid < n && ((mid + 1) * (mid + 1)) > n)) {
                return mid;
            }
            if (mid * mid < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        System.out.println(findSqrt(n));
    }
}
