class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0,r=0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while(r<s.length()){
            int chNum = s.charAt(r)-'0';
            map.put(chNum,map.getOrDefault(chNum,0)+1);
            while(map.getOrDefault(1,0) != 0 && map.get(1) > k){
                int freq = map.get(s.charAt(l)-'0');
                map.put(s.charAt(l)-'0',freq-1);
                l++;
            }
            if(map.getOrDefault(1,0) != 0 && map.get(1) == k){
                while(s.charAt(l)-'0' == 0){
                    int freq = map.get(s.charAt(l)-'0');
                    map.put(s.charAt(l)-'0',freq-1);
                    l++;
                }
                if(minLen > r-l+1){
                    res = new String(s.substring(l,r+1));
                    minLen = r-l+1;
                }
                else if(minLen == r-l+1){
                    String curr = s.substring(l,r+1);
                    if(res.compareTo(curr) >= 0){
                        res = curr;
                    }
                }
            }
            r++;
        }
        return res;
    }
}