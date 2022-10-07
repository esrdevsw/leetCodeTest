package lct.amazon;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int maxarea = 0;
		for (int left = 0; left < height.length; left++) {
			for (int right = left + 1; right < height.length; right++) {
				int width = right - left;
				maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
			}
		}
		return maxarea;
	}
	
	public int maxArea2(int[] height) {
        int maxarea = 0;
        int left = 0; 
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContainerWithMostWater cwmw = new ContainerWithMostWater();

		int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(cwmw.maxArea(nums));
		
		System.out.println(cwmw.maxArea2(nums));

	}
}
