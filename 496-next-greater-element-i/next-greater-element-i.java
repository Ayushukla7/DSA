class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Stack<Integer> stack = new Stack<>();
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int num : nums2) {
//             while (!stack.isEmpty() && stack.peek() < num) {
//                 map.put(stack.pop(), num);
//             }
//             stack.push(num);
//         }

//         while (!stack.isEmpty()) {
//             map.put(stack.pop(), -1);
//         }

//         int[] result = new int[nums1.length];
//         for (int i = 0; i < nums1.length; i++) {
//             result[i] = map.get(nums1[i]);
//         }

//         return result;
//     }
// }
// class Solution {
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int greater = -1;
            boolean found = false;

            // nums2 me nums1[i] ko find karo
            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == nums1[i]) {

                    // uske right side ko check karo
                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > nums1[i]) {
                            greater = nums2[k];
                            found = true;
                            break;
                        }
                    }

                    break;
                }
            }

            ans[i] = greater;
        }

        return ans;
    }
}