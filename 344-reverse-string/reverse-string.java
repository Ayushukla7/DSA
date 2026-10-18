class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
    void reverse(char[] s, int left, int right) {

        // Base case: dono pointers mil gaye
        if (left >= right) {
            return;
        }

        // Dono characters ko swap karo
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Aage badho
        reverse(s, left + 1, right - 1);
    }
}