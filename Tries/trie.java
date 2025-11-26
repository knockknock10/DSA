package Tries;

public class trie {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L) longest word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

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

    public static boolean wordbreak(String key) { // O(L)
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // substring(beg idx,last idx(it is exclusive it will never come))
            // substring(0,i) so here when i is 0 it becomes invalid
            if (search(key.substring(0, i)) &&
                    wordbreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String word[] = { "the", "a", "there", "their", "any", "thee" };
        // for (int i = 0; i < word.length; i++) {
        // insert(word[i]);
        // }
        // System.out.println(search("there"));
        // System.out.println(search("thorr"));
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordbreak(key));
    }
}