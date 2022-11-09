class Solution {

    public long findGcd(long a, long b) {
        long dividend = Math.max(a, b);
        long divisor = Math.min(a, b);
        while (divisor != 1) {
            long remainder = dividend % divisor;
            if (remainder == 0) {
                return divisor;
            }
            dividend = divisor;
            divisor = remainder;
        }
        return divisor;
    }

    public long findLcm(long a, long b) {
        return (a * b) / findGcd(a, b);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = Math.min(Math.min(a, b), c);
        long high = (long) (n * Math.min(Math.min(a, b), c));
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long elemCount = mid / a + mid / b + mid / c - mid / findLcm(a, b) - mid / findLcm(b, c) - mid / findLcm(a, c) + mid / findLcm(findLcm(a, b), c);
            // System.out.println(elemCount);
            if (elemCount == n && (mid % a == 0 || mid % b == 0 || mid % c == 0)) {
                return (int) mid;
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
