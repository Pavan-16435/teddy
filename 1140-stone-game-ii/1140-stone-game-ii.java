class Solution {
    int[] suffixSum;
    int[][] memo;
    int n;
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        memo = new int[n][n + 1];
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        
        return dp(0, 1, piles);
    }
    
    private int dp(int i, int m, int[] piles) {
        if (i >= n) return 0;
        
        // If remaining piles can all be taken
        if (i + 2 * m >= n) {
            return suffixSum[i];
        }
        
        if (memo[i][m] != -1) {
            return memo[i][m];
        }
        
        int best = 0;
        for (int X = 1; X <= 2 * m; X++) {
            if (i + X > n) break;
            int newM = Math.max(m, X);
            int stonesForOpponent = dp(i + X, newM, piles);
            int stonesForMe = suffixSum[i] - stonesForOpponent;
            best = Math.max(best, stonesForMe);
        }
        
        memo[i][m] = best;
        return best;
    }
}