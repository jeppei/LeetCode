
public class MaximumSubarray {

    public static void main(String[] args) {
        int [] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
        System.out.println("RESULT: " + bestResult);
    }
    
    static int[] theNums;
    static int[] results;
    static int bestResult = Integer.MIN_VALUE;
    
    public static int maxSubArray(int[] nums) {
        // A[i, j] = the sum of integer ai to aj.
        // A[i, i] = ai
        // A[i, j] = A[i, k] + A[k, j] where i<k<j
        // A[i, j] = 0 if j<i
        // A[i, j] = A[i, j-1] + aj
        
        
        // A[k] = max sub array using a1, ..., ak where k<n
        // A[1] = a1
        
        // A[i] = A[i-1] if ai<0
        //        max[A[i-1], A[i-1]+ai]
        
        
        // A[k] = max sub array using a1, ..., ak which includes ak
        
        
        // [-2, 1,  -3, 4,  -1, 2,  1,  -5, 4]
        //  
        //  -2  1,  -2, 4,  3,  5,  6,  1,  5
        
        // A[k] = max(ak, A[k-1]+ak)
        
        int n = nums.length;
        theNums = nums;
        //results = new int[n];
        maxSum(n-1);
        return bestResult;
        
    }
    
    public static int maxSum(int i) {
        if (i==0) {
            //results[i] = theNums[0];
            bestResult = java.lang.Math.max(theNums[0], bestResult);
            return theNums[0];
        }
        int result = java.lang.Math.max(theNums[i], maxSum(i-1)+theNums[i]);
        bestResult = java.lang.Math.max(result, bestResult);
        //results[i] = result;
        return result;
    }
}