class Solution {

    public int findMinElCount(int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min((k / i), n);
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = findMinElCount(m, n, mid);

            if (count >= k) {
                if (findMinElCount(m, n, mid - 1) < k) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
