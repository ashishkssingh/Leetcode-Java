package Algorithms.TwoSumIIInputarrayissorted;

import java.util.Arrays;

class TwoSumIIInputarrayissorted {
    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                answer[0] = i + 1;
                answer[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

}