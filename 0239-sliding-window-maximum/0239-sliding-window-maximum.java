class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int r=0,index=0;
        int[] res = new int[nums.length-k+1];
        while(r<nums.length){
            
            if(!q.isEmpty() && q.peekFirst() <= r-k){
                q.pollFirst();
            }

            while(!q.isEmpty() && nums[q.peekLast()] <= nums[r]){
                q.pollLast();
            }

            q.offerLast(r);

            if(r >= k-1){
                res[index++] = nums[q.peekFirst()];
            }
            r++;
        }
        return res;
    }
}