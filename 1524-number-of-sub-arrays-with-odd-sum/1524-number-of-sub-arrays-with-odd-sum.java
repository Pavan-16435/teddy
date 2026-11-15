class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int count = 0,prefixSum = 0;
        int oddCount = 0,evenCount = 1;
        for(int num : arr){
            prefixSum += num;

            if(prefixSum %2 == 0){
                count = count + oddCount;
                evenCount++;
            }
            
            else{
                count = count + evenCount;
                oddCount++;
            }
            
            count = count%MOD;


        }

        return count;

    }
}