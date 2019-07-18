class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) {
            return results;
        }
        
        Arrays.sort(candidates);
        
        dfs(candidates, 
            new ArrayList<Integer>(), 
            results,
            target,
            0);
        
        return results;
    }
    
    public void dfs(int[] candidates, List<Integer> subset, List<List<Integer>> results, int target, int index) {
        if(target == 0) {
            results.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }
            
            subset.add(candidates[i]);
            
            // dfs continues
            dfs(candidates, 
                subset, 
                results,
                target - candidates[i],
                i);
            
            // backtrack
            subset.remove(subset.size() - 1);
        }
        
    }

}
