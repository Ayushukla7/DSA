class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] halfFreq = new int[26];
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }
        long totalPerms = countPermutations(halfFreq, k);
        if (totalPerms < k) {
            return "";
        }
        StringBuilder firstHalf = new StringBuilder();
        int m = s.length() / 2;
        for (int pos = 0; pos < m; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (halfFreq[ch] == 0) continue;
                halfFreq[ch]--;
                long cnt = countPermutations(halfFreq, k);
                if (k > cnt) {
                    k -= cnt;
                    halfFreq[ch]++;
                } else {
                    firstHalf.append((char) ('a' + ch));
                    break;
                }
            }
        }
        String halfStr = firstHalf.toString();
        StringBuilder ans = new StringBuilder(halfStr);
        if (oddCount == 1) {
            ans.append(midChar);
        }
        ans.append(new StringBuilder(halfStr).reverse());
        return ans.toString();
    }

    private long countPermutations(int[] freq, long cap) {
        long ans = 1;
        int total = 0;  
        for (int f : freq) {
            if (f == 0) continue;
            if (total == 0) {
                total += f;
                continue;
            }            
            int k = Math.min(f, total);
            int n = total + f;        
            for (int i = 1; i <= k; i++) {
                ans = ans * (n - i + 1) / i;
                if (ans > cap) return cap + 1;
            }
            total += f;
        }     
        return ans;
    }
}