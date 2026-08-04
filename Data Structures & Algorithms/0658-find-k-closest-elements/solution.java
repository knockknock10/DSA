class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> m = new PriorityQueue<>();
        for(int i:arr){
            if(k>0){
                m.offer(i);
                k--;
            }else if(Math.abs(m.peek()-x)>Math.abs(i-x)){
                m.poll();
                m.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
            while(!m.isEmpty()){
                ans.add(m.poll());
            }
        return ans;
    }
}
