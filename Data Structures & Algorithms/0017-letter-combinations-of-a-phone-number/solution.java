class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> ans = new ArrayList<>();
        ans.add("");
        for(int i=0;i<digits.length();i++){
            String let = map[digits.charAt(i)-'0'];
            List<String> temp  = new ArrayList<>();
            for(String s:ans){
                for (int j = 0;j<let.length(); j++) {
                    temp.add(s+let.charAt(j));
                }
            }
            ans = temp;
        }
        return ans;

    }
}
