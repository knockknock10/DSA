class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] l = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                l[i] = st.pop();
                l[l[i]] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0,d = 1;i<n;i+=d){
            if(s.charAt(i)>='a') sb.append(s.charAt(i));
            else {
                i = l[i];
                d = -d;
            }
        }
        return sb.toString();
    }
}
