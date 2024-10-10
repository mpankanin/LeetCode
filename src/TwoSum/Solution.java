package TwoSum;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//Constraints:
//
//2 <= nums.length <= 104
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
//
//
//Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        IntStream indices = IntStream.range(0, nums.length);
        Map<Integer, List<Integer>> valueIndexesMap = new HashMap<>();
        indices.forEach(index -> {
            int value = nums[index];
            if (valueIndexesMap.containsKey(value)) {
                valueIndexesMap.get(value).add(index);
            } else {
                valueIndexesMap.put(value, new ArrayList<>(List.of(index)));
            }
        });

        for (int index = 0; index < nums.length; index++) {
            int wanted = target - nums[index];
            if (valueIndexesMap.containsKey(wanted)) {
                List<Integer> indexesOfValue = valueIndexesMap.get(wanted);
                if (indexesOfValue.size() > 1) {
                    int firstValue = indexesOfValue.getFirst();
                    return new int[] {index, firstValue != index ? firstValue : indexesOfValue.get(1)};
                } else if (indexesOfValue.getFirst() != index){
                    return new int[] {index, indexesOfValue.getFirst()};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSumBetter(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }

}
