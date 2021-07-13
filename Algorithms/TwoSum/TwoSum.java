package Algorithms.TwoSum;
import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> complement_map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(complement_map.containsKey(complement)){
                return new int[] {complement_map.get(complement), i};
            }
            complement_map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum pair found!");
    }

    public static void main(String[] args){
        TwoSum two = new TwoSum();
        System.out.println(Arrays.toString(two.twoSum(new int[]{2,7,11,15}, 9)));
    }
}