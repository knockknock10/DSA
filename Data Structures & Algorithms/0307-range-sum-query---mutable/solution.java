class Node {
    int start, end, sum;
    Node left, right;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SegmentTree {
    Node root;

    SegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    //O(N)
    Node build(int[] nums, int start, int end) {
        if (start > end)
            return null;
        Node root = new Node(start, end);
        if (start == end) {
            //left
            root.sum = nums[start];
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(nums, start, mid);
        root.right = build(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    //O(2*logn)
    int Query(Node root, int ql, int qr) {
        //no overlap
        if (root.end < ql || root.start > qr) {
            return 0;
        }
        if (root.start >= ql && root.end <= qr) {
            //comlpletly overlap
            return root.sum;
        }
        return Query(root.left, ql, qr) + Query(root.right, ql, qr);
    }
    //O(logn)
    int update(Node root, int idx, int val) {
        if(root==null) return 0;
        if (idx<root.start || idx>root.end) {
            return root.sum;//no overlap
        }
        if (root.start == root.end) {
            root.sum = val;
            return root.sum;
        }
        root.sum = update(root.left,idx,val)+update(root.right,idx,val);
        return root.sum;
    }
}

class NumArray {
    SegmentTree tree;

    public NumArray(int[] nums) {
        tree = new SegmentTree(nums);
    }
    public void update(int index, int val) {
        tree.update(tree.root,index,val);
    }

    public int sumRange(int left, int right) {
        return tree.Query(tree.root,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
