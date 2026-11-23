class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            minVal = Math.min(minVal,prices[i]);
            max = Math.max(max,prices[i]-minVal);
        }
        return max;
    }
}