public class tree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Binarytree{
        static int idx = -1;
        public static Node tree(int node[]){
            idx++;
            if(node[idx]==-1){
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = tree(node);
            newNode.right = tree(node);
            return newNode;
        }
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
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        return countNode(root.left)+countNode(root.right)+1;
    }
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,-1,-1};
        Node root = Binarytree.tree(node);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.err.println();
        System.out.println(countNode(root));
        
    }
}
