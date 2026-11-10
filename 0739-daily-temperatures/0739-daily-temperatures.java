class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        // int[] arr = new int[temperatures.length];
        int n = temperatures.length;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]){
                int index = s.pop();
                temperatures[index] = i - index;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int index = s.pop();
            temperatures[index] = 0;
        }
        return temperatures; 
    }
}