class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = binarySearch(nums, target, 0, nums.length - 1, true);

        int last = binarySearch(nums, target, 0, nums.length - 1, false);

        return new int[]{first, last};
    }

    static int binarySearch(int[] nums, int target, int start, int end, boolean findFirst) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {

            if (findFirst) {
                int left = binarySearch(nums, target, start, mid - 1, true);

                if (left == -1) {
                    return mid;
                }

                return left;

            } else {

                int right = binarySearch(nums, target, mid + 1, end, false);

                if (right == -1) {
                    return mid;
                }

                return right;
            }
        }

        if (target < nums[mid]) {
            return binarySearch(nums, target, start, mid - 1, findFirst);
        }

        return binarySearch(nums, target, mid + 1, end, findFirst);
    }
}