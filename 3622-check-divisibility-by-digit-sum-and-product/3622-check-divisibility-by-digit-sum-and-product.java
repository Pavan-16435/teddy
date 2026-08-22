class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while(n > 0){
            int rem = n%10;
            sum = sum + rem;
            prod = prod*rem;
            n = n/10;
        }
        return temp%(sum+prod) == 0? true : false;
    }
}