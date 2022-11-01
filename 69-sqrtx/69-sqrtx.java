class Solution {

    public int mySqrt(int x) {
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sqVal = (long) mid * mid;
            if (sqVal == x || (sqVal < x && (((long) (mid + 1) * (mid + 1)) > x))) {
                return mid;
            }
            if (sqVal < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
