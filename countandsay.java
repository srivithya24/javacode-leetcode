class Solution {
    public String countAndSay(int n) {
        String current = "1";
        
        // Iteratively build the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
            
            while (j < current.length()) {
                char val = current.charAt(j);
                int count = 0;
                
                // Count consecutive identical characters
                while (j < current.length() && current.charAt(j) == val) {
                    count++;
                    j++;
                }
                
                // Append "count" followed by "value"
                next.append(count).append(val);
            }
            current = next.toString();
        }
        
        return current;
    }
}
