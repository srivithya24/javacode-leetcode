class Solution:
    def canJump(self, nums):
        farthest = 0
        
        for i in range(len(nums)):
            # If current index is beyond the farthest reachable point, stop
            if i > farthest:
                return False
            
            # Update how far we can possibly get
            farthest = max(farthest, i + nums[i])
            
            # If we can reach or pass the last index, we're done
            if farthest >= len(nums) - 1:
                return True
                
        return False
