import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class que {
    // Mostly asked question Queue using linked list microsoft
    // static class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }

    // }
    // public static class Queue{
    //     // static int arr[];
    //     // static int size;
    //     // static int rear;
    //     // static int front;
    //     // Queue(int n ){
    //     //     arr = new int[n];
    //     //     size = n;
    //     //     rear = -1;
    //     //     front = -1;
    //     // }
    //     // public static boolean isEmpty(){
    //     //     return rear == -1 && front == -1;
    //     // }
    //     // public static boolean isfull() {
    //     //     return (rear+1)%size == front;
    //     // }
    //     // public static void add(int data){
    //     //     if(isfull()){
    //     //         System.out.println("queue is full");
    //     //         return;
    //     //     }
    //     //     //add 1st element
    //     //     if(front == -1){
    //     //         front = 0;
    //     //     }
    //     //     rear = (rear+1)%size;
    //     //     arr[rear]= data;
    //     // }
    //     // public static int remove(){
    //     //     if(isEmpty()){
    //     //         System.out.println("Queue is empty");
    //     //         return -1;
    //     //     }
    //     //     int res = arr[front];
    //     //     //last el delete
    //     //     if(rear == front){
    //     //         rear = front = -1;
    //     //     }else{
    //     //         front = (front+1)%size;
    //     //     }   
    //     //     return res;
    //     // }
    //     // public static int peek(){
    //     //     if(isEmpty()){
    //     //         System.out.println("Queue is Empty");
    //     //         return -1;
    //     //     }
    //     //     return arr[front];
    //     // }

    //     static Node head = null;
    //     static Node tail = null;
    //     public static boolean isEmpty(){
    //         return head==null && tail==null;
    //     }
    //     public static void add(int data){
    //         Node newnode = new Node(data);
    //         if(head==null){
    //             head = tail = newnode;
    //             return; 
    //         }tail.next = newnode;
    //         tail = newnode;
    //     }
    //    public static int remove(){
    //      if(isEmpty()){
    //         System.out.println("Queue is full");
    //         return -1;
    //      }
    //     int front = head.data;
    //     //single element
    //      if(tail == head){
    //         tail=head=null;
    //      }else{
    //         head = head.next;
    //      }
    //      return front;
    //    }
    //    static int peek(){
    //     if(isEmpty()){
    //         System.out.println("Queue is empty");
    //         return -1;
    //     }
    //     return head.data;
    //    }
    // }
    public static void main(String[] args) {

        //Queue q = new Queue(5);
        // Queue q = new Queue();
        Queue q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        q.add(1);
        q.add(2);
        q.add(3);
       // System.out.println(q.remove());
        q.add(4);
      //  System.out.println(q.remove());
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove(); 
        }

    }
}
