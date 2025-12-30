package Tries;

public class trie {
    // prefix problem

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findprefix(Node root, String ans) { // O(L) levels of trie = longest word
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findprefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    // static class Node {
    // Node children[] = new Node[26];
    // boolean eow = false;

    // Node() {
    // for (int i = 0; i < children.length; i++) {
    // children[i] = null;
    // }
    // }
    // }

    // public static Node root = new Node();

    // public static void insert(String word) { // O(L) longest word
    // Node curr = root;
    // for (int level = 0; level < word.length(); level++) {
    // int idx = word.charAt(level) - 'a';
    // if (curr.children[idx] == null) {
    // curr.children[idx] = new Node();
    // }
    // curr = curr.children[idx];
    // }
    // curr.eow = true;
    // }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    // startWith Problem
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    // public static boolean wordbreak(String key) { // O(L)
    // if (key.length() == 0) {
    // return true;
    // }
    // for (int i = 1; i <= key.length(); i++) {
    // // substring(beg idx,last idx(it is exclusive it will never come))
    // // substring(0,i) so here when i is 0 it becomes invalid
    // if (search(key.substring(0, i)) &&
    // wordbreak(key.substring(i))) {
    // return true;
    // }
    // }
    // return false;
    // }

    // Count uinque Substring
    public static int coutnNodes(Node root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += coutnNodes(root.children[i]);
            }

        }
        return count + 1;
    }

    public static void main(String[] args) {
        // String word[] = { "the", "a", "there", "their", "any", "thee" };
        // for (int i = 0; i < word.length; i++) {
        // insert(word[i]);
        // }
        // System.out.println(search("there"));
        // System.out.println(search("thorr"));
        // String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }
        // String key = "ilikesamsung";
        // System.out.println(wordbreak(key));

        // prefix problem
        // String arr[] = { "zebra", "dog", "duck", "dove" };
        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }
        // root.freq = -1;
        // findprefix(root, "");
        // String words[] = { "apple", "app", "mango", "man", "women" };
        // String prefix1 = "app";
        // String prefix2 = "moon";
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }
        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));

        // Count Unique Substring
        String str = "ababa";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(coutnNodes(root));
    }
}
