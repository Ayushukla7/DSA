class Solution {
    public int vowelConsonantScore(String s) {
        int cc=0;
        int vc=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vc++;
                }
                else{
                    cc++;
                }
            }
        }
        if(vc==0 || cc==0){
            return 0;
        }
        return vc/cc;
    }
}