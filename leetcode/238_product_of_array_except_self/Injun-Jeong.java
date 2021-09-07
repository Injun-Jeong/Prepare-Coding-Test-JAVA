package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q238_ProductOfArrayExceptSelf {
    int[] answer;
    Set<Integer> idxOfZeroVal;
    int multipliedAllNumNotZero;

    public int[] productExceptSelf(int[] nums) {
        answer = new int[nums.length];
        findZeroValIdx(nums);

        if (idxOfZeroVal.size() >= 2) {
            Arrays.fill(answer, 0);
            return answer;
        }

        getAnswer(nums);

        return answer;
    }


    private void findZeroValIdx(int[] nums) {
        idxOfZeroVal = new HashSet<>();
        multipliedAllNumNotZero = 1;

        for (int idx = 0; idx < nums.length; idx++) {
            if (idxOfZeroVal.size() >= 2) {
                break;
            }

            if (nums[idx] == 0) {
                idxOfZeroVal.add(idx);
            } else {
                multipliedAllNumNotZero *= nums[idx];
            }
        }
    }


    private void getAnswer(int[] nums) {
        for (int idx = 0; idx < nums.length; idx++) {
            if (idxOfZeroVal.isEmpty()) {
                answer[idx] = multipliedAllNumNotZero / nums[idx];
            }
            else if (!idxOfZeroVal.contains(idx)) {
                answer[idx] = 0;
            }
            else {
                answer[idx] = multipliedAllNumNotZero;
            }
        }
    }
}
