class Solution {
    class Interval{
        int index;
        int left;
        int right;
        int weight;
        public Interval(int index, int left, int right, int weight){
            this.index = index;
            this.left = left;
            this.right = right;
            this.weight = weight;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        List<Interval> list = new ArrayList<>();
        int n = intervals.size();
        for (int i = 0; i < intervals.size(); i++){
            Interval cur = new Interval(i, intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2));
            list.add(cur);
        }
        Collections.sort(list, (o1,o2)->(o1.right-o2.right));
        long[][] dp = new long[n][5];
        List<Integer>[][] chosenIndices = new ArrayList[n][5];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 5; j++){
                chosenIndices[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++){
            for (int picked = 1; picked <= 4; picked++){
                Interval cur = list.get(i);
                long skipWeight = 0, noSkipWeight = 0;
                List<Integer> skipCombine = new ArrayList<>();
                List<Integer> noSkipCombine = new ArrayList<>();
                if (i != 0) {
                    skipWeight = dp[i-1][picked];
                    skipCombine = new ArrayList<>(chosenIndices[i-1][picked]);
                }
                int p = search(list, cur.left);
                noSkipWeight = cur.weight;
                if (p != -1) {
                    noSkipWeight += dp[p][picked-1];
                    noSkipCombine = new ArrayList<>(chosenIndices[p][picked-1]);
                }
                noSkipCombine.add(cur.index);
                Collections.sort(noSkipCombine);
                if (compare(skipWeight, skipCombine, noSkipWeight, noSkipCombine)){
                    chosenIndices[i][picked] = skipCombine;
                    dp[i][picked] = skipWeight;
                }else{
                    chosenIndices[i][picked] = noSkipCombine;
                    dp[i][picked] = noSkipWeight;
                }
            }
        }
        List<Integer> res = chosenIndices[n-1][4];
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    private boolean compare(long skipWeight,List<Integer> skipCombine,long noSkipWeight,List<Integer> noSkipCombine){
        if (skipWeight > noSkipWeight) return true;
        else if (skipWeight < noSkipWeight) return false;
        for (int i = 0; i < Math.min(skipCombine.size(), noSkipCombine.size()); i++){
            if (skipCombine.get(i) < noSkipCombine.get(i)) return true;
            else if (skipCombine.get(i) > noSkipCombine.get(i)) return false;
        }
        if (skipCombine.size() < noSkipCombine.size()) return true;
        else return false;
    }
    private int search(List<Interval> list, int leftBound){
        int left = 0, right = list.size()-1;
        int ans = -1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (list.get(mid).right < leftBound){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}
