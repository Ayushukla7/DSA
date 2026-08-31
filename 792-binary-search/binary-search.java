// class Solution {
//     public int search(int[] nums, int target) {
//       int start = 0;
//       int end = nums.length - 1;
//       while(start<=end){
//         int mid = start + (end - start)/2;
//         if (target < nums[mid]){
//             end = mid -1;
//         }else if (target > nums[mid]){
//             start = mid + 1;
//         }else{
//             return mid;
//         }
       
//       } 
//        return -1; 
//     }
// }
                       //using recursive
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    static int binarySearch(int[] nums, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (target < nums[mid]) {
            return binarySearch(nums, target, start, mid - 1);
        }

        return binarySearch(nums, target, mid + 1, end);
    }
}