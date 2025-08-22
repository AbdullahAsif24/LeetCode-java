import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class hackerRank {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        String[] subS = new String[s.length() - k + 1];

        for (int i = 0; i < s.length() - k + 1; i++) {
            subS[i] = s.substring(i, i + k);
        }

        smallest = subS[0];
        largest = subS[0];
        for (String string : subS) {
            if (string.compareTo(smallest) < 0) {
                smallest = string;
            }
            if (string.compareTo(largest) > 0) {
                largest = string;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void isPalindromeFunc() {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        boolean isPalindrome = true;
        int mid = A.length() / 2;

        int start = 0;
        int end = A.length() - 1;
        while (start < mid && end > mid) {
            if (A.charAt(start) != A.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");

        }
    }

    

    public static void main(String[] args) {
        

    }
}
