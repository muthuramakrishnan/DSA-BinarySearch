class Solution {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || nums[mid - 1] != nums[mid]) && (mid == n - 1 || nums[mid + 1] != nums[mid])) {
                return nums[mid];
            }
            if ((mid % 2 == 0 && nums[mid + 1] == nums[mid]) || (mid % 2 != 0 && nums[mid - 1] == nums[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
