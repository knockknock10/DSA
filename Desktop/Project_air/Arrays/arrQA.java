package Arrays;

public class arrQA {
    // max subarray (Kadne's algo)
    public static void kadne(int arr[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.print("BY kadne algo " + ms);
    }

    public static void main(String[] args) {

    }
}