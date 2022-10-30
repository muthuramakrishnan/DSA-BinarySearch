class Solution {

    public int hIndex(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int possibleAns = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n - mid) {
                return arr[mid];
            } else if (arr[mid] < n - mid) {
                possibleAns = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low > high ? n - low : possibleAns;
    }
}
