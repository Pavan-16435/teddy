class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cur = new int[26];
        for (char c : s.toCharArray()) cur[c - 'a']++;

        int fallbackIndex = -1;
        char fallbackChar = 0;
        int[] fallbackCount = null;

        for (int i = 0; i < n; i++) {
            int tc = target.charAt(i) - 'a';

            for (int c = tc + 1; c < 26; c++) {
                if (cur[c] > 0) {
                    fallbackIndex = i;
                    fallbackChar = (char) ('a' + c);
                    fallbackCount = cur.clone();
                    fallbackCount[c]--;
                    break;
                }
            }

            if (cur[tc] > 0) {
                cur[tc]--;
            } else {
                break;
            }
        }

        if (fallbackIndex == -1) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, fallbackIndex);
        sb.append(fallbackChar);
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < fallbackCount[c]; k++) sb.append((char) ('a' + c));
        }
        return sb.toString();
    }
}