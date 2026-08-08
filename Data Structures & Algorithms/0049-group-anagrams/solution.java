class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char temp[] = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = String.valueOf(temp);
            if(map.get(s)!=null){
                List<String> a = map.get(s);
                a.add(strs[i]);
                map.put(s,a);
            }else{
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                map.put(s,a);
            }
        }
        for(Map.Entry<String,List<String>> x:map.entrySet()){
            ans.add(x.getValue());
        }
        return ans;
    }
}
