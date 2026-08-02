
public class AMq{
    
    //A.M Car Pooling Tc O(N+K) Sc O(K)
    public boolean carPooling(int[][] trips,int capacity){
        int[]  a = new int[1001];
        for(int a[]:trips){
            a[a[1]]+=a[0];
            a[a[2]]+=a[0];
        }
        for(int i=0;capacity>=0 && i<1001;i++){
            capacity-=a[i];
        }
        return capacity>=0
    }
    public static void main(String[] args){
        
    }
}