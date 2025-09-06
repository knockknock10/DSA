import java.util.Scanner;

public class mergesort {
    public static void cal(int bod) {
        int cy = 2025;
        int c = cy - bod;
        int a = c * 365;
        System.out.println("no of days from birth is :" + a + "days");
    }

    public static void asci(char ch) {
        int n = 98;
        char val = (char) n;
        int aci = (int) ch;
        System.out.println(val);
        System.out.println(aci);
    }

    public static void tem(double c) {
        double f = (c * 9.0 / 5.0) + 32;
        System.out.println("This is temp " + f);
    }

    public static void check(int age) {
        if (age >= 18) {
            System.out.println("You are eligible for vote");
        } else {
            System.out.println("you are not eligible for vote");
        }
    }

    public static void impli() {
        int a = 10;
        double b = 11.2;
        double c = a + b;
        System.out.println(c);
        // convert char to int by add to char 'B' and print integer value in result
        char ad = 'B';
        int f = ad + 10;
        System.out.println(f);
        double val = 12.999999;
        int num = (int) val;
        System.out.println(val + "  this is int :" + num);
        char ch = 'c';
        double add = ch + 2.50;
        System.out.println(add);

    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;// iterator for left part
        int j = mid + 1;// iterator for right part
        int k = 0; // iterator for newly created array

    }

    public static void msort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        msort(arr, si, mid); // left part
        msort(arr, mid + 1, ei);// right part
        merge(arr, si, mid, ei);
    }

    public static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void calac(int a, int b, char ch) {
        if (a > b) {
            System.out.println("a is greater than b");
        } else if (a == b) {
            System.out.println("both are equal");
        } else {
            System.out.println("b is smaller");
        }
        switch (ch) {
            case '+':
                System.out.println(a + b);
                break;

            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;

            default:
                System.out.println("wrong input");
                break;
        }

    }

    public static int high_score = 1000;

    public static int loop(int high_score){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            int a = sc.nextInt();
            high_score+=a;
        }
        return high_score;
    }
    // qno 3
    public static void getid(int bod,int fn){
        int n = bod%100;
        int res = n | fn;
        System.out.println(res);

    }
 





    public static void main(String[] args) {
        int high_score = 0;

        Scanner sc = new Scanner(System.in);
        int dob = sc.nextInt();
        int fav = sc.nextInt();
        getid(dob, fav);



        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // char ch = '+';
        // // calac(a, b, ch);
        // System.out.println();

        // int asd = loop(high_score);
        
        // if(high_score>asd){
        //     System.out.println("local");
        // }else if(mergesort.high_score>asd){
        //     System.out.println("global");
        // }else{
        //     System.out.println("noone");
        // }
        // // int bod = 2008;
        // cal(bod);
        // char ch = 'b';
        // asci(ch);
        // double c = 33.4;
        // tem(c);
        // int age = 19;
        // check(age);
        // impli();

    }
}
