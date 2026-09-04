class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] suffixMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int stableMin = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            min = Math.min(min,nums[i]);
            suffixMin[i] = min;
        }
        int instable = -1;
        int index = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            instable = max - suffixMin[i];
            if(instable <= k){
                index = Math.min(index,i);
            }
        }
        return index==Integer.MAX_VALUE ? -1 : index;
    }
}