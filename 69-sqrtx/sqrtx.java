class Solution {
    public int mySqrt(int x) {

        int c = 0;

        while ((long)(c + 1) * (c + 1) <= x) {
            c++;
        }

        return c;
    }
}