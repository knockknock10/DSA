import java.util.Stack;

public class javastack{
    //check if there is a valid parenthesis in the string
    //valid parenthesis means that every opening bracket has a closing bracket in the correct order
    //e.g. "()" is valid, "(]" is not valid, "({[]
    public static boolean isvalid(String str){

        Stack<Character> s = new Stack<>();
        for(int i = 0 ;i<str.length();i++){
            char ch = str.charAt(i);
            //opening
            if(ch=='(' || ch=='{' || ch=='['){
                
                s.push(ch);
            }else{
                //closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && ch==')')
                || (s.peek()=='{' && ch=='}')
                || (s.peek()=='[' && ch==']')
                ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    } 
    public static void main (String args[]){
        String str = "(){[()]}";
        System.out.println(isvalid(str));
    }
}