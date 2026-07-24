class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        mx <<= 1;        
        boolean[] pairXor = new boolean[mx];
        for (int a : nums) {
            for (int b : nums) {
                pairXor[a ^ b] = true;
            }
        }        
        int[] ans = new int[mx];
        for (int xor = 0; xor < mx; xor++) {
            if (pairXor[xor]) {
                for (int c : nums) {
                    ans[xor ^ c] = 1;
                }
            }
        }
        int count = 0;
        for (int x : ans) {
            count += x;
        }
        return count;
    }
}