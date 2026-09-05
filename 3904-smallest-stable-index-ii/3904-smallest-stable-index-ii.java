class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] suffixMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            min = Math.min(nums[i],min);
            suffixMin[i] = min;
        }
        int max = Integer.MIN_VALUE;
        int index = Integer.MAX_VALUE;
        int instable = -1;
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