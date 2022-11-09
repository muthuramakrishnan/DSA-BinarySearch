class Solution {

    public int findGcd(int a, int b) {
        int dividend = Math.max(a, b);
        int divisor = Math.min(a, b);
        while (divisor != 1) {
            int remainder = dividend % divisor;
            if (remainder == 0) {
                return divisor;
            }
            dividend = divisor;
            divisor = remainder;
        }
        return divisor;
    }

    public int findLcm(int a, int b) {
        return (a * b) / findGcd(a, b);
    }

    public int nthMagicalNumber(int n, int a, int b) {
        long low = Math.min(a, b);
        long high = (long) n * (long) Math.min(a, b);
        int mod = (int) Math.pow(10, 9) + 7;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long elemCount = (mid / a) + (mid / b) - (mid / findLcm(a, b));
            if (elemCount == n && (mid % a == 0 || mid % b == 0)) {
                return (int) (mid % mod);
            }
            if (elemCount >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
