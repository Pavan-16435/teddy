class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (m > n) return new int[0];
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        // suf[j] = position in word1 for backward-greedy match of word2[j:], suf[m] = n
        int[] suf = new int[m + 1];
        suf[m] = n;
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (w1[i] == w2[j]) {
                suf[j] = i;
                j--;
            }
            i--;
        }
        // remaining unmatched suffixes of word2 are impossible to match at all
        for (int k = 0; k <= j; k++) {
            suf[k] = -1;
        }
        
        // nextOcc[p][c] = smallest index >= p where word1 has char c, or n if none
        int[][] nextOcc = new int[n + 1][26];
        for (int c = 0; c < 26; c++) nextOcc[n][c] = n;
        for (int p = n - 1; p >= 0; p--) {
            System.arraycopy(nextOcc[p + 1], 0, nextOcc[p], 0, 26);
            nextOcc[p][w1[p] - 'a'] = p;
        }
        
        int[] result = new int[m];
        int p = 0;
        boolean changeUsed = false;
        
        for (int q = 0; q < m; q++) {
            if (p >= n) return new int[0];
            
            if (w1[p] == w2[q]) {
                result[q] = p;
                p++;
            } else {
                boolean feasible = suf[q + 1] >= p + 1;
                if (!changeUsed && feasible) {
                    // use our single allowed change right here (smallest index)
                    result[q] = p;
                    p++;
                    changeUsed = true;
                } else {
                    // must find an exact match further ahead
                    int np = nextOcc[p + 1][w2[q] - 'a'];
                    if (np == n) return new int[0];
                    p = np;
                    result[q] = p;
                    p++;
                }
            }
        }
        
        return result;
    }
}