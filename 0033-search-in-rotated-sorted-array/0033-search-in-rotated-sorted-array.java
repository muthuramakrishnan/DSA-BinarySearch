class Solution {

    public int findElement(int[] arr, int low, int high, int k) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= arr[n - 1]) {
                high = mid - 1;
            } else {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);
        if (n == 1 || pivot==-1) {
            return findElement(nums, 0, n - 1, target);
        }
        return target > nums[n - 1] ? findElement(nums, 0, pivot, target) : findElement(nums, pivot + 1, n - 1, target);
    }
}
