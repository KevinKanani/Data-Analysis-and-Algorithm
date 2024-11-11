class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0) return null;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = i + 1;
        List<List<Integer>> result = new ArrayList<>();
        backtrace(nums, new ArrayList<Integer>(), n, result, new boolean[n], k);
        StringBuilder sb = new StringBuilder();
        List temp = result.get(result.size() - 1);
        for(int i = 0; i < n; i++)
            sb.append(temp.get(i));
        return sb.toString();
    }
    private static void backtrace(int[] nums, List<Integer> list, int n, List<List<Integer>> result, boolean[] used, int k){
        if(list.size() == n){
            result.add(new ArrayList<Integer>(list));
            if(result.size() == k)
                return;
        }else{
            if(result.size() == k)
                return;
            for(int i = 0; i < n; i++){
                if(used[i]) continue;
                list.add(nums[i]);
                used[i] = true;
                backtrace(nums, list, n, result, used, k);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
