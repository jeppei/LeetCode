//https://leetcode.com/problems/reverse-integer/submissions/

class Solution {
    public int reverse(int x) {
        
        
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        
        if (0 <= x) {

            for (int i = s.length()-1; 0 <= i; i--) {
                sb.append(s.charAt(i));
            }

            String t = sb.toString();
            return Integer.parseInt(t);
            
        } else {
            
            
            for (int i = s.length()-1; 0 < i; i--) {
                sb.append(s.charAt(i));
            }

            String t = sb.toString();
            return (Integer.parseInt(t))*-1;
            
        }
    }
}