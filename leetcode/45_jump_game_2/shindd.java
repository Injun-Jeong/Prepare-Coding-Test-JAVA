import static java.lang.Math.min;

class Solution {

	private int[] minimumJumpsToReach;

	private int size;

	public int jump(int[] nums) {
		init(nums);
		return solve(nums);
	}

	private void init(int[] nums) {
		this.size = nums.length;
		this.minimumJumpsToReach = new int[size + 1];
	}

	private void updateJumpsToReach(int currentJumps, int target) {
		if (this.minimumJumpsToReach[target] == 0) {
			this.minimumJumpsToReach[target] = currentJumps + 1;
			return;
		}
		this.minimumJumpsToReach[target] = min(this.minimumJumpsToReach[target], currentJumps + 1);
	}

	private int solve(int[] nums) {
		for (int index = 0; index < this.size - 1; index++) {
			for (int target = index + 1; target <= index + nums[index] && target < this.size; target++) {
				updateJumpsToReach(this.minimumJumpsToReach[index], target);
			}
		}
		return this.minimumJumpsToReach[size - 1];
	}
}