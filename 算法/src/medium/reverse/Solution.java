package medium.reverse;

/**
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 */

/**
 * 478 / 478 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 52.8 MB
 */

class Solution {
    public void reverseString(char[] s) {
        int end;
        char tempChar;
        int length = s.length;
        if (length % 2 == 0) {
            end = length/2;
        } else {
            end = (length-1)/2;
        }
        for (int i=0; i< end;i ++ ){
            tempChar = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = tempChar;
        }
    }

    public void main(String args[]) {
        char[] input = {'h','e','l','l','o'};
        reverseString(input);
        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        };
    }
}