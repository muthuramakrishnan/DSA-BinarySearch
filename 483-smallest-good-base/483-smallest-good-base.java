class Solution {

    public String smallestGoodBase(String ipString) {
        long n = Long.parseLong(ipString);
        for (int i = 63; i >= 0; i--) {
            long low = 2, high = n - 1;
            while (low <= high) {
                long m = low + (high - low) / 2;
                long sum = 0, powerVal = 1;
                boolean flag = false;
                for (int j = 0; j <= i; j++) {
                    sum += powerVal;
                    if (sum >= n) {
                        break;
                    }
                    if (j < i && ((n - sum) / powerVal) < m) {
                        flag = true;
                        break;
                    } else if (j < i) {
                        powerVal *= m;
                    }
                }
                if (sum > n || flag == true) {
                    high = m - 1;
                } else if (sum < n) {
                    low = m + 1;
                } else {
                    return Long.toString(m);
                }
            }
        }
        return "-1";
    }
}
