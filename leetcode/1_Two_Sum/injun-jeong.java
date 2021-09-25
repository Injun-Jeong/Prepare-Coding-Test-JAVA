package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx++) {
            if (map.containsKey(nums[idx]) && nums[idx] * 2 == target) {
                answer[0] = map.get(nums[idx]);
                answer[1] = idx;
                return answer;
            }
            map.put(nums[idx], idx);
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if (map.containsKey(target - nums[idx])) {
                answer[0] = idx;
                answer[1] = map.get(target - nums[idx]);
                break;
            }
        }

        return answer;
    }
}
