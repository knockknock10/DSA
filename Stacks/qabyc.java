import java.util.Stack;

public class qabyc {   
    public static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }//add
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.add(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }//remove
        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(s1.isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            return s1.peek();
        }
    }
    //finding the largest rectangle in a histogram    // T.C  O(n)
    public static void maxArea_histogram(int arr[]){
        int maxarea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        //next smaller right    O(n)
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller left    O(n)
        s = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //current area : width = j-i-1 = nsr[i]-nsl[i]-1  O(n)
        for(int i = 0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currarea = height*width;
            maxarea = Math.max(currarea,maxarea);
        }
        System.out.println("maxium area in histogram is "+maxarea);
         
    }
    public static void main(String args[]){
        // int arr[]={2,1,5,6,2,3};
        // maxArea_histogram(arr);
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
