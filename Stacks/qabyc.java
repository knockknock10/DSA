import java.util.Stack;

public class qabyc {          // T.C  O(n)
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
        int arr[]={2,1,5,6,2,3};
        maxArea_histogram(arr);
    }
}
