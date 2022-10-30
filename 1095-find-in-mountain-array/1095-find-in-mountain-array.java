/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

interface SortType {
    String ASC_SORT = "ASC_SORT";
    String DESC_SORT = "DESC_SORT";
}

class Solution implements SortType {

    public int binarySearch(int target, int low, int high, MountainArray arr, String sortType) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = arr.get(mid);

            if (midVal == target) {
                return mid;
            }
            if (midVal < target) {
                if (sortType == SortType.ASC_SORT) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (sortType == SortType.ASC_SORT) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIdx = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal > mountainArr.get(mid + 1) && midVal > mountainArr.get(mid - 1)) {
                peakIdx = mid;
                break;
            }
            if (mid == 0 || mountainArr.get(mid - 1) < midVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int resIdx = binarySearch(target, 0, peakIdx, mountainArr, SortType.ASC_SORT);
        if (resIdx == -1) {
            resIdx = binarySearch(target, peakIdx + 1, n - 1, mountainArr, SortType.DESC_SORT);
        }
        return resIdx;
    }
}
