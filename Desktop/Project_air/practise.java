import java.util.*;

public class practise {
    public static void bubble_sort(int arr[]) {// O(n^2)
        for (int i = 0; i < arr.length; i++) { /// O(n)
            for (int j = 0; j < arr.length - 1 - i; j++) { // O(n-1)
                if (arr[j] > arr[j + 1]) {
                    // int temp = arr[j];
                    // arr[j] = arr[j + 1];
                    // arr[j + 1] = temp;
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];

                }
            }
        }
    }

    public static void selection_sort(int arr[]) {// O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minpos] > arr[j]) {
                    minpos = j;
                }
            }
            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printarrr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //
    public static void minabsdi(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int mindiff = 0;
        for (int i = 0; i < a.length; i++) {
            mindiff += Math.abs(a[i] - b[i]);
        }
        System.out.println("min absoulute pair is : " + mindiff);
    }

    // MAximum length chain of pairs T.C(O(nlogn))
    public static void maxchain() {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        Arrays.sort(pairs, Comparator.comparing(o -> o[1]));

        int chainlen = 1;
        int chainend = pairs[0][1];// lastselected pair end //chain end

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainend) {
                chainlen++;
                chainend = pairs[i][1];
            }
        }
        System.out.println("max length of chain pair : " + chainlen);
    }

    // Indian coins solution
    public static void indiancoins() {
        // to sort in rev order our arr should be as Integer not int
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int countofcoins = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countofcoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Minimum no of coins to be give is : " + countofcoins);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    // Job Sequencing Problem
    static class Job {
        int deadline;
        int profit;
        int id;// 1(a),2(b)

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }

    }

    public static class Book {
        String title;
        String author;
        int year;

        void details(String t, String a, int y) {
            title = t;
            author = a;
            year = y;
        }

        void display() {
            System.out.println(this.author + " , " + this.title + " ," + this.year);
        }

    }

    public static void chocola() {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costhor[] = { 4, 1, 2 };
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costhor, Collections.reverseOrder());
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        while (h < costhor.length && v < costVer.length) {
            if (costVer[v] <= costhor[h]) {// horizontal cut
                cost += (costhor[h] * vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costhor.length) {
            cost += (costhor[h] * vp);
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += (costVer[v] * vp);
            vp++;
            v++;
        }
        System.out.println("total min cost is : " + cost);
    }

    public static void main(String args[]) {
        // Book book1 = new Book();
        // book1.details("This house is haunted", "kr", 2012);
        // book1.display();
        chocola();

        // int arr[] = { 5, 4, 3, 2, 1 };
        // // bubble_sort(arr);
        // selection_sort(arr);
        // printarrr(arr);
        // int a[] = { 4, 1, 8, 7 };
        // int b[] = { 2, 3, 6, 5 };
        // minabsdi(a, b);
        // maxchain();
        // indiancoins();
        // int jobsinfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        // // Job jobs[] = new Job[jobsinfo.length];
        // ArrayList<Job> jobs = new ArrayList<>();
        // for (int i = 0; i < jobsinfo.length; i++) {
        // jobs.add(new Job(i, jobsinfo[i][0], jobsinfo[i][1]));
        // }
        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);// decs
        // order
        // // for asc just Collections.sort(jobs,(a,b) -> a.profit-b.profit);

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time = 0;
        // for (int i = 0; i < jobs.size(); i++) {
        // Job curr = jobs.get(i);
        // if (curr.deadline > time) {
        // seq.add(curr.id);
        // time++;
        // }
        // }
        // // print seq
        // System.out.println("max jobs = " + seq.size());
        // for (int i = 0; i < seq.size(); i++) {
        // System.out.print(seq.get(i) + " ");
        // }
        // System.out.println();
    }
}