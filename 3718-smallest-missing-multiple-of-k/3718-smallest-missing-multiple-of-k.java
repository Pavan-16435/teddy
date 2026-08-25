class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num%k == 0){
                set.add(num);
            }
        }
        int n = k;
        int res = -1;
        while(true){
            if(!(set.contains(n))){
                res = n;
                break;
            }
            n = n + k;
        }
        return res;
    }
}