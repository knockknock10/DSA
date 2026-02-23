import java.util.LinkedList;
import java.util.Queue;

public class pract {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    Node root;
    public  void  insertlevel(int data){
        Node newNode = new Node(data);
        if(root==null) {
            root = newNode;
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(newNode);
        while(!qu.isEmpty()){
            Node temp = qu.poll();//retrive and return the head first ele of que
            if(temp.left==null){
                temp.left = newNode;
                break;
            }else{
                qu.add(temp.left);
            }
            if(temp.right == null){
                temp.right = newNode;
                break;
            }else{
                qu.add(temp.right);
            }
        }
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
    public static int countNode(Node root){
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        return 1+countNode(root.left)+countNode(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data>key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
    public static int minu(Node root){
        while (root.left!=null) {
            root = root.left;
        }
        return root.data;
    }
    public static int maxx(Node root){
        while(root.right!=null){
            root = root.right;
        }
        return root.data;
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }
    public static boolean isfull(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.left!=null && root.right!=null){
            return isfull(root.left) && isfull(root.right);
        }
        return false;
    }
    
    public static void main(String[] args) {
       pract tree = new pract();
       tree.insertlevel(2);
       tree.insertlevel(2);
    }
}
