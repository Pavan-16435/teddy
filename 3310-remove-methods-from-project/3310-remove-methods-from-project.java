class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] inv : invocations) {
            graph.computeIfAbsent(inv[0], x -> new ArrayList<>()).add(inv[1]);
        }
        
        // Find suspicious set: all methods reachable from k
        Set<Integer> suspicious = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        suspicious.add(k);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.getOrDefault(node, Collections.emptyList())) {
                if (!suspicious.contains(next)) {
                    suspicious.add(next);
                    queue.add(next);
                }
            }
        }
        
        // Check if any edge from outside suspicious set points into it
        for (int[] inv : invocations) {
            int a = inv[0], b = inv[1];
            if (suspicious.contains(b) && !suspicious.contains(a)) {
                // Cannot remove, return all methods
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }
        
        // Safe to remove suspicious methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}