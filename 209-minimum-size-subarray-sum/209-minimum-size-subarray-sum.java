class Solution {

    public boolean doesSubArrMakeupTargetVal(int[] nums, int target, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = k; i < n; i++) {
            if (sum >= target) {
                return true;
            }
            sum += nums[i];
            sum -= nums[i - k];
        }
        return sum >= target;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (doesSubArrMakeupTargetVal(nums, target, mid+1)) {
                if (mid == 0 || !doesSubArrMakeupTargetVal(nums, target, mid)) {
                    return mid+1;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
