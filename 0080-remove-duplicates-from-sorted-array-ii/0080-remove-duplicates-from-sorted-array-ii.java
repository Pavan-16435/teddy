class Solution {
    public int removeDuplicates(int[] nums) {
        int freq = 1;
        int j = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[j] && freq == 2){
                continue;
            }
            if(nums[i] == nums[j]){
                freq++;
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            else{
                freq = 1;
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return j+1;
    }
}