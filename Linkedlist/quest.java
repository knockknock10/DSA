public class quest{
    
    public static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    //A.E Merge two sorted linked list
    public static Node megre(Node l1,Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.data<l2.data){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        Node ans = l1;
        while(l1!=null && l2!=null){
            Node temp = null;
            while(l1!=null && l1.data<=l2.data){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            Node t = l1;
            l1 = l2;
            l2 = t;
        }
        return ans;
    }
    //Intersection of two linked list 
    public static Node interaction(Node l1,Node l2){
        if(l1==null || l2 == null) return null;
        Node p1 = l1, p2 = l2;
        while(p1!=p2){
            p1 = (p1==null) ? l2 :p1.next;
            p2 = (p2==null) ? l1 :p2.next;
            
        }
        return p1;  
    }
    //AM  Partiotion List  TC O(n) SC O(1)
    public static Node partition (Node head,int x){
        Node beforehead = new Node(0);
        Node before = beforehead;
        Node afterhead = new Node(0);
        Node after = afterhead;
        
        while(head!=null){
            if(head.data<x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
            
        }
        after.next = null;
        before.next = afterhead.next;
        return beforehead.next;
        
    }
    //AM sum of subarray ranges
    public static long subranges(int[] nums){
        int n = nums.length;
        long ans = 0;
        for(int i=0;i<n;i++){
            int minv = nums[i];
            int maxv = nums[i];
            for(int j=i;j<n;j++){
                maxv = Math.max(maxv, nums[j]);
                minv = Math.min(minv,nums[j]);
                ans+=maxv-minv;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}