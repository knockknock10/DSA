import java.util.LinkedList;
import java.util.Queue;

public class tree {
    public static class  Node {
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int idx = -1;
    public static Node bttree(int data[]) {
        idx++;
        if(data[idx]==-1){
            return null;
        }
        Node newnNode = new Node(data[idx]);
        newnNode.left = bttree(data);
        newnNode.right = bttree(data);
        return newnNode;
        
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
    //Level order
    public static void levelorder(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curNode = q.remove();
            if(curNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.println(curNode+" ");
                if(curNode.left!=null){
                    q.add(curNode.left);
                }
                if(curNode.right!=null){
                    q.add(curNode.right);
                }
            }
        }
    }
    //height of tree TC O(n)
    public static int heighttree(Node root){
        if(root==null){
            return 0;
        }
        int left = heighttree(root.left);
        int right = heighttree(root.right);
        return Math.max(left,right)+1;
    } 
    //Counting the no nodes TC O(n)
    public static int coutnNodes(Node root){
        if(root==null){
            return 0;
        }
        int left = coutnNodes(root.left);
        int right = coutnNodes(root.right);
        return left+right+1;
    }
    public static void main(String[] args) {
        int data[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = bttree(data);
        System.out.println(root.data); 
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println(heighttree(root));
        System.out.println(coutnNodes(root));
    
    }
}
