import java.util.HashMap;
import java.util.Stack;

public class leetcode {

    /*
     * ================= Q1 ======================
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * 
     * You can return the answer in any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    /*
     * ================= Q2 ======================
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
     * and M.
     * 
     * Symbol Value
     * I 1
     * V 5
     * X 10
     * L 50
     * C 100
     * D 500
     * M 1000
     * For example, 2 is written as II in Roman numeral, just two ones added
     * together. 12 is written as XII, which is simply X + II. The number 27 is
     * written as XXVII, which is XX + V + II.
     * 
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is
     * written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There
     * are six instances where subtraction is used:
     * 
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     * 
     * 
     */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = romanMap.get(s.charAt(i));
            if (i + 1 < s.length()) {

                int value2 = romanMap.get(s.charAt(i + 1));
                if (value < value2) {
                    total += (value2 - value);
                    i++;
                    continue;
                }

            }
            total += value;

        }

        return total;
    }

    /*
     * ================= Q3 ======================
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     * 
     * An input string is valid if:
     * 
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     * 
     * 
     * Example 1:
     * 
     * Input: s = "()"
     * 
     * Output: true
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> crMap = new HashMap<>();
        crMap.put(')', '(');
        crMap.put('}', '{');
        crMap.put(']', '[');

        for (char c : s.toCharArray()) {
            if (crMap.containsValue(c)) {
                stack.push(c);
            } else if (crMap.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != crMap.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /*
     * ================= Q4 ======================
     * You are given a large integer represented as an integer array digits, where
     * each digits[i] is the ith digit of the integer. The digits are ordered from
     * most significant to least significant in left-to-right order. The large
     * integer does not contain any leading 0's.
     * 
     * Increment the large integer by one and return the resulting array of digits.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     */

    public static int[] plusOneFunc(int[] digits) {
        int n = digits.length;

        // Start from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, just increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If current digit is 9, set it to 0 and continue to next digit
            digits[i] = 0;
        }

        // If we're here, all digits were 9, we need to add a new digit at the beginning
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    /*
     * ================= Q5 ======================
     * ================= Remove Duplicates from sorted Array ======================
     * Consider the number of unique elements of nums to be k, to get accepted, you
     * need to do the following things:
     * 
     * Change the array nums such that the first k elements of nums contain the
     * unique elements in the order they were present in nums initially. The
     * remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * Custom Judge:
     * 
     * The judge will test your solution with the following code:
     * 
     * int[] nums = [...]; // Input array
     * int[] expectedNums = [...]; // The expected answer with correct length
     * 
     * int k = removeDuplicates(nums); // Calls your implementation
     * 
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     * If all assertions pass, then your solution will be accepted.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements
     * of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are
     * underscores).
     */

    public static int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /*
     * ===================Search Insert Position====================
     * Given a sorted array of distinct integers and a target value, return the
     * index if the target is found. If not, return the index where it would be if
     * it were inserted in order.
     * 
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     */

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /*
     * ====================Find the Index of the First Occurrence in a String===============
     * Given two strings needle and haystack, return the index of the first
     * occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     */

    public static int strStr(String haystack, String needle) {
        for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode", needle = "leeto";

        System.out.println(strStr(haystack, needle));
    }

}