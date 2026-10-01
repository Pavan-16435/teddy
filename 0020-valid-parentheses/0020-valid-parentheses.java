class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else{
                    char open = st.pop();
                    if((ch == ')' && open != '(') || 
                       (ch == '}' && open != '{') ||
                       (ch == ']' && open != '[')){
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}