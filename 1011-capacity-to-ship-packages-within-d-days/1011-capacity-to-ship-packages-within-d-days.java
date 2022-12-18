class Solution {

    public boolean canBeTransportedWithinGivenDays(int[] weights, int capacity, int requiredDays) {
        int n = weights.length;
        int days = 1, tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += weights[i];
            if (tempSum > capacity) {
                tempSum = weights[i];
                days++;
            }
        }
        return days <= requiredDays;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canBeTransportedWithinGivenDays(weights, mid, days)) {
                if (!canBeTransportedWithinGivenDays(weights, mid - 1, days)) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (canBeTransportedWithinGivenDays(weights, low, days)) {
            return low;
        }
        return -1;
    }
}
