class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            int num = digits[i];
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<digits.length;k++){
                    if(i != j  && j != k && i != k){
                        if(digits[i] != 0){
                            int res = digits[i]*100+digits[j]*10+digits[k];
                            if(res%2 == 0){
                                set.add(res);
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }
}