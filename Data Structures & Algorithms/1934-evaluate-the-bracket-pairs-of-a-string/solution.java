class Solution {
    public String evaluate(String s, List<List<String>> K) {
        Map<String,String> d= new HashMap<>();
        for(var k:K){
            d.put(k.get(0),k.get(1));
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int j = s.indexOf(')',i+1);
                res.append(d.getOrDefault(s.substring(i+1,j),"?"));
                i=j;
            }else {res.append(s.charAt(i));}
        }
        return res.toString();
    }
}
