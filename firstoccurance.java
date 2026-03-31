class Solution {
    public int strStr(String haystack, String needle) {
        // Handle edge cases
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        // Loop through haystack until needle can no longer fit
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring starting at i matches needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}
