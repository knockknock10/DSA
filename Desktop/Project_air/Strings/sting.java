public class sting {
    // Check if string is palindrome T.c O(n)
    public static boolean palindrome(String s) {
        for (int i = 0; i < (s.length()) / 2; i++) {
            int n = s.length();
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // route given with 4 directions find the shortest path ti reach destination
    // wneenesennn o/p 5 n&e y+1 and W&S y-1 T.c O(n)
    public static float shortpath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'S') {
                y--;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'W') {
                x--;
            } else if (dir == 'E') {
                x++;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    // Find the largest string T.C O(n)
    public static void largstr() {
        String fruits[] = { "apple", "mango", "bananana" };
        String largest = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println("largest string is : " + largest);
    }

    public static void main(String[] args) {
        String s = "madam";
        System.out.println(palindrome(s));
        String path = "WNEENESENNN";
        System.out.println(shortpath(path));
        largstr();

    }
}
