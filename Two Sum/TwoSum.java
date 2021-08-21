/**
 * TwoSum
 */
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        
        int[] nums = new int[] {2,7,11,15}; 
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println("[" + result[0] + "," + result[1] + "]");

        
        nums = new int[] {3,2,4}; 
        target = 6;
        result = twoSum(nums,target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
    
    public static int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        HashMap<Integer, Integer> goodOnes = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++) {
            int number = nums[i];

            int soulMate = target-number;
            if (goodOnes.containsKey(soulMate)) {
                return new int[] {i, goodOnes.get(soulMate)};
            }

            goodOnes.put(number, i);
        }

        return null;
        
    }
}