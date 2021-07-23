package Algorithms.PlusOne;

import java.util.Arrays;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int last = digits.length - 1;

        while (last >= 0) {
            if (digits[last] == 9) {
                digits[last] = 0;
            } else {
                digits[last] += 1;
                break;
            }
            last--;
        }

        if (digits[0] == 0) {
            int[] newResult = new int[length + 1];
            newResult[0] = 1;
            return newResult;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 9, 9 };
        PlusOne plus = new PlusOne();
        System.out.println(Arrays.toString(plus.plusOne(nums)));
    }
}