

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
    public static void main(String[] args) {
        int data[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = bttree(data);
        System.out.println(root.data); 
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    
    }
}
