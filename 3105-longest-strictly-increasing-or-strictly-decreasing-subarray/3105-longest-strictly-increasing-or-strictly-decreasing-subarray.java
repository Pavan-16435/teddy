class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int strInc = 1;
        int strDec = 1;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                strInc++;
                strDec = 1;
            }
            else if(nums[i] < nums[i-1]){
                strDec++;
                strInc = 1;
            }
            else{
                strInc = 1;
                strDec = 1;
            }
            max = Math.max(max,Math.max(strDec,strInc));
        }
        return max;
    }
}