import java.util.Arrays;

class Solution {

	private int width;
	private int height;
	private int[][] matrix;
	private int[][] distancesToZero;

	private static final int[][] DIRECTIONS = {{-1, -0}, {1, 0}, {0, 1}, {0, -1}};
	private static final int UNDEFINED = Integer.MAX_VALUE;

	public int[][] updateMatrix(int[][] matrix) {
		init(matrix);
		solve();
		return this.distancesToZero;
	}

	private void init(int[][] matrix) {
		this.matrix = matrix;
		this.width = matrix[0].length;
		this.height = matrix.length;
		this.distancesToZero = new int[height][width];
		for (int[] array : this.distancesToZero) {
			Arrays.fill(array, UNDEFINED);
		}
	}

	private void solve() {
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				if (this.matrix[y][x] == 0) {
					spread(y, x, 0);
				}
			}
		}
	}

	private boolean isInBound(int y, int x) {
		return (0 <= y && y < this.height) && (0 <= x && x < this.width);
	}

	private void spread(int y, int x, int distance) {
		if (this.distancesToZero[y][x] <= distance) {
			return;
		}
		this.distancesToZero[y][x] = distance;
		for (int[] dir : DIRECTIONS) {
			if (isInBound(y + dir[0], x + dir[1]) && this.matrix[y + dir[0]][x + dir[1]] != 0) {
				spread(y + dir[0], x + dir[1], distance + 1);
			}
		}
	}
}