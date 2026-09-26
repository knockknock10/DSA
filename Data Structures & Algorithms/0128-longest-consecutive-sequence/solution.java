class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums) s.add(i);
        int count = 0;
        for(int i:s){
            if(!s.contains(i-1)){
                int dum = 1;
                int num = i+1;
                while(s.contains(num)){
                    dum++;
                    num++;
                }count = Math.max(count,dum);
            }
        }
        return count;
    }
}
