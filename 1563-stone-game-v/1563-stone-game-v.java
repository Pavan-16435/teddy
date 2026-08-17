class Solution {
    private int[] prefix;
    private Integer[][] memo;
    
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        memo = new Integer[n][n];
        return solve(0, n - 1);
    }
    
    private int sum(int i, int j) {
        // sum of stoneValue[i..j] inclusive
        return prefix[j + 1] - prefix[i];
    }
    
    private int solve(int i, int j) {
        if (i == j) return 0; // only one stone left, game ends
        
        if (memo[i][j] != null) return memo[i][j];
        
        int best = 0;
        
        // try every possible split point k: left = [i..k], right = [k+1..j]
        for (int k = i; k < j; k++) {
            int leftSum = sum(i, k);
            int rightSum = sum(k + 1, j);
            
            int score;
            if (leftSum < rightSum) {
                score = leftSum + solve(i, k);
            } else if (leftSum > rightSum) {
                score = rightSum + solve(k + 1, j);
            } else {
                // equal, Alice picks the better continuation
                score = leftSum + Math.max(solve(i, k), solve(k + 1, j));
            }
            
            best = Math.max(best, score);
        }
        
        memo[i][j] = best;
        return best;
    }
}