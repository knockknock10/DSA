
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
    //kth largest element in an array Tc O(NlogK) Sc O(K)
    public int findlargest(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
         for(int i:nums){
            pq.offer(i);
            if(pq.size()<k){
                pq.poll();
            }
         }
         return pq.peek();
    }
    
    
    
    
    
    
    
    
    
    public static void main(String[] args){
        system.out.println("Hello World");
    }
}