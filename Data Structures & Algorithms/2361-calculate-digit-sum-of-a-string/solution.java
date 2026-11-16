class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder n = new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                int sum = 0;
                for(int j=i;j<s.length() && j<i+k;j++){
                    sum+=s.charAt(j)-'0';
                }
                n.append(sum);
            }
            s = n.toString();
        }
        return s;
    }
}
