import java.util.ArrayList;
import java.util.Stack;

public class javastack{
    static ArrayList<Integer> list = new ArrayList<>();
    public static boolean isempty(){
        return list.size()==0;
    }
    public static void push(int data){
        list.add(data);
    }
    public static int pop(int data){
        int top = list.get(list.size()-1);
        list.remove(top);
        return top;
    }
    public static int peek(){
        if(isempty()){
            return -1;
        }
        return list.get(list.size()-1);
    }

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
    public static boolean isDuplicate(String str1){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            //closing
            if(ch==')'){
                int count = 0;
                //while(isempty) we wont write bcz it will be never empty as it isclosing and 
                //the  str given is valid str
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }                   //minimize code by just while(s.pop()!....)
                                //no need to write that s.pop() again
                if(count<1){
                    return true;//duplicate
                }else{
                    s.pop();//opening  pair         //even here no need to write this else statement
                }
            }else{
                //opening
                s.push(ch);
            }
        }return false;
    }

    public static void main (String args[]){
        String str = "(){[()]}";
        //System.out.println(isvalid(str));
        String str1 = "(a-b)";
        System.out.println(isDuplicate(str1));
    }
}