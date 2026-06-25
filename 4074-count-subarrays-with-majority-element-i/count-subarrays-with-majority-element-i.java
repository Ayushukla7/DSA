import java.util.*;

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cnt.clear();

            for (int j = i; j < n; j++) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);

                int len = j - i + 1;
                if (cnt.getOrDefault(target, 0) > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}