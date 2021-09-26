package leetcode;

public class Q11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int maxarea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxarea = maxarea > Math.min(height[left], height[right]) * (right - left) ? maxarea : Math.min(height[left], height[right]) * (right - left);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }

        return maxarea;
    }
}
