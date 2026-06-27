class Solution {
    public int maximumLength(int[] nums) {
        int maxNum = 0;
        Map<Long, Integer> count = new HashMap<>();

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        int ans = count.containsKey(1L)
                ? count.get(1L) - (count.get(1L) % 2 == 0 ? 1 : 0)
                : 1;

        for (int num : nums) {
            if (num == 1)
                continue;

            int length = 0;
            long x = num;

            while (x <= maxNum && count.getOrDefault(x, 0) >= 2) {
                length += 2;
                x *= x;
            }

            // Agar x present hai to center banega (+1),
            // warna pichla element center banega (-1)
            length += count.containsKey(x) ? 1 : -1;

            ans = Math.max(ans, length);
        }

        return ans;
    }
}