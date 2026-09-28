class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left=0;
        int right=tokens.length-1;
        Arrays.sort(tokens);
        int currScore=0;
        int maxScore=0;
        while(left<=right){
                if(power>=tokens[left]){
                    power=power-tokens[left];
                    currScore++;
                    left++;
                }else if(currScore>0){
                    power=power+tokens[right];
                    currScore--;
                    right--;
                }else{
                    break;
                }
                maxScore=Math.max(currScore,maxScore);
        }
        return maxScore;
    }
}