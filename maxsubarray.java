class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide: Start new or extend?
            // currentSum = max(current_element, previous_sum + current_element)
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the overall maximum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
