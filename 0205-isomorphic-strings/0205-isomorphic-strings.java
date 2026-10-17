class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            
            if(map.containsKey(ch) && map.get(ch) != ch1){
                return false;
            }

            if(map1.containsKey(ch1) && map1.get(ch1) != ch){
                return false;
            }

            map.put(ch,ch1);
            map1.put(ch1,ch);

        }
        return true;
    }
}