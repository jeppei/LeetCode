import java.util.*; 



class Solution {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(result);

    }
    public static String convert(String s, int numRows) {
        if (s == "") return "";
        
        StringBuilder[] rows = new StringBuilder[numRows];
        
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        
        int index = 0;
        boolean hasMoreChars = true;
        while (hasMoreChars) {
            for (int row = 0; row < numRows; row++) {
                if (index == s.length()) {
                    break;
                }
                System.out.println("Adding " + s.charAt(index) + " to row " + row);
                rows[row].append(s.charAt(index++));
            }
            
            for (int row = numRows-2; 0 < row; row--) {
                if (index == s.length()) {
                    break;
                }
                System.out.println("Adding " + s.charAt(index) + " to row " + row);
                rows[row].append(s.charAt(index++));
            }
            hasMoreChars = index != s.length();
            System.out.println("index: " + index + ", s.length()=" + s.length());
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            String myRow = rows[i].toString();
            result.append(myRow);
            System.out.println(myRow);
        }
        
        return result.toString();
        
    }
}