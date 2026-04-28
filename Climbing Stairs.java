class Solution {
    public int climbStairs(int n) {
        // Base cases: 1 step = 1 way, 2 steps = 2 ways
        if (n <= 2) {
            return n;
        }

        int first = 1;  // Ways to reach step 1
        int second = 2; // Ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = first + second;
            // Shift the values forward for the next step
            first = second;
            second = current;
        }

        return second;
    }
}
