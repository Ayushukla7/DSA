class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        int push = 1;

        for (int i = 0; i < n / 8; i++) {
            ans += 8 * push;
            push++;
        }

        ans += (n % 8) * push;

        return ans;
    }
}