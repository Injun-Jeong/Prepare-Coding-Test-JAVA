package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q560_Subarray_Sum_Equals_K {
    private int answer;

    public int subarraySum(int[] nums, int k) {
        //bruteForce(nums, k);
        hashMap(nums, k);
        return answer;
    }

    private void bruteForce(int[] nums, int k) {
        answer = 0;

        for (int src = 0; src < nums.length; src++) {
            int temp = 0;
            for (int idx = src; idx < nums.length; idx++) {
                temp += nums[idx];
                if (temp == k) {
                    answer++;
                }
            }
        }
    }

    private void hashMap(int[] nums, int k) {
        answer = 0;
        Map<Integer, Integer> sumOccurenceMap = new HashMap<>();
        sumOccurenceMap.put(0, 1);

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if ( sumOccurenceMap.containsKey(sum - k) ) {
                answer += sumOccurenceMap.get(sum - k);
            }
            sumOccurenceMap.put(sum, sumOccurenceMap.getOrDefault(sum, 0) + 1);
        }
    }
}
