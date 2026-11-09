class Solution {
    public static void nextGreat(int[] arr,int[] nums2,int start,int index){
        for(int i=start+1;i<nums2.length;i++){
           if(nums2[i] > nums2[start]){
            arr[index] = nums2[i];
            break;
           }
        }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    nextGreat(arr,nums2,j,i);
                    break;
                }
            }
        }
        return arr;
    }
}