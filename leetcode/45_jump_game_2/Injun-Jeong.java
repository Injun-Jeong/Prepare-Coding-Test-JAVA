package leetcode;


import java.util.Arrays;

public class Q045_JumpGameII {
    int[] memo;
    int len;
    int lastIdx;

    public int jump(int[] nums) {
        initVar(nums);
        findMinNumJump(nums);
        return memo[lastIdx];
    }

    private void initVar(int[] nums) {
        len = nums.length;
        lastIdx = len - 1;
        memo = new int[len];
        Arrays.fill(memo, 0);
    }

    private void findMinNumJump(int[] nums) {
        for (int idx = 0; idx < lastIdx; idx++) {
            if (memo[lastIdx] != 0) return;
            updateMemo(idx, nums[idx]);
        }
    }

    private void updateMemo(int idx, int num) {
        for (int cnt = 1; cnt <= num; cnt++) {
            if ( idx + cnt == len ) {
                return;
            } else {
                memo[idx + cnt] = ( memo[idx + cnt] == 0 )
                                    ? memo[idx] + 1
                                    : memo[idx + cnt];
            }
        }
    }
}
