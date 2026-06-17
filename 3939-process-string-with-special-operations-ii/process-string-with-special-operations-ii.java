class Solution {
    public char processStr(String s, long k) {

        long len = 0;

        
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                len++;
            } else if (ch == '*') {
                len = Math.max(0, len - 1);
            } else if (ch == '#') {
                len *= 2;
            }
        }

        if (k >= len) {
            return '.';
        }

        
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len--;

                if (k == len) {
                    return ch;
                }

            } else if (ch == '*') {
                len++;

            } else if (ch == '#') {
                len /= 2;

                if (k >= len) {
                    k -= len;
                }

            } else if (ch == '%') {
                k = len - 1 - k;
            }
        }

        return '.';
    }
}