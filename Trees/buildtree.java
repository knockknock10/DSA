public class buildtree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = ;
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
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,-1,-1};
        Node root = Binarytree.tree(node);
        System.out.println(root.data);
    }
}
