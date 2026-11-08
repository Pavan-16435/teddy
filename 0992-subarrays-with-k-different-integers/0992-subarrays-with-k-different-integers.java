class Solution {
    public static int ksize(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0,r=0;
        int distinctCount = 0;
        int count = 0;
        while(r<nums.length){
            int num = nums[r];
            if(map.containsKey(num) == false){
                distinctCount++;
            }
            map.put(num,map.getOrDefault(num,0)+1);
            while(distinctCount > k){
                int val = map.get(nums[l]);
                map.put(nums[l],--val);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                    distinctCount--;
                }
                l++;
            }
            if(distinctCount <= k){
                count = count + (r-l+1);
            }
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMostK = ksize(nums,k);
        int atMostKSub1 = ksize(nums,k-1);
        return atMostK - atMostKSub1;
    }
}