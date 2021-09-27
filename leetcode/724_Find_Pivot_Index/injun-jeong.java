package leetcode;

public class Q724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, sum = 0;
        for (int num : nums) sum += num;

        for (int idx = 0; idx < nums.length; idx++) {
            if (leftSum == sum - leftSum - nums[idx]) {
                return idx;
            }
            leftSum += nums[idx];
        }

        return -1;
    }
}
