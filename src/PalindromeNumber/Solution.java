package PalindromeNumber;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(100011));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int xSize = 1;
        int tmp = x;

        do {
            xSize++;
            tmp = tmp / 10;
        } while (tmp > 9);

        int[] digits = new int[xSize];

        tmp = x;
        while (xSize > 0) {
            digits[--xSize] = tmp % 10;
            tmp = tmp / 10;
        }

        int right = 0;
        int left = digits.length - 1;

        while (right < left) {
            if (digits[right] != digits[left]) {
                return false;
            }
            right++;
            left--;
        }

        return true;
    }

}
