package problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (complement == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumTwoPass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement)) {
                return new int[]{j, map.get(complement)};
            }
        }

        throw new IllegalStateException("There are no two values in the array that sum to the target");
    }

    public static int[] twoSumOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalStateException("There are no two values in the array that sum to the target");
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 26;
        int[] result = twoSumOnePass(nums, target);
        for (int i: result) {
            System.out.println(i);
        }

    }
}
