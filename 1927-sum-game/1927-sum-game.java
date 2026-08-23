class Solution {
    public boolean sumGame(String num) {
        int n = num.length() / 2;
        long sum1 = 0, sum2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '?'){
                cnt1++;
            }
            else{
                sum1 += (ch - '0');
            }
        }
        for (int i = n; i < 2 * n; i++) {
            char ch = num.charAt(i);
            if (ch == '?'){
                cnt2++;
            }
            else {
                sum2 += (ch - '0');
            }
        }

        int cntTotal = cnt1 + cnt2;
        if (cntTotal % 2 == 1) return true;

        long diff = sum1 - sum2;
        long forced = 2 * diff + 9L * (cnt1 - cnt2);
        return forced != 0;
    }
}