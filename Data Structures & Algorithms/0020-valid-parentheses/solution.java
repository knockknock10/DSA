class Solution {
    public boolean isValid(String s) {
       Stack<Character> c = new Stack<>();
       for(char i:s.toCharArray()){
        if(i=='(' || i=='{' || i=='['){
            c.push(i);
        }else{
            if(c.isEmpty()) return false;
            char top = c.pop();
            if((i==')'&& top!='(') || (i=='}' && top!='{') || (i==']' && top!='[')){
                return false;
            }
        }
       }
       return c.isEmpty();
    }
}
