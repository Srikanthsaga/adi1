
import java.util.HashMap;
import java.util.Map;

public class Assign3 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        
        int longestSubsequenceLength = findLHS(nums);
        
        System.out.println("Length of longest harmonious subsequence: " + longestSubsequenceLength);
    }
    
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each number in the array
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int longestSubsequenceLength = 0;
        
        // Iterate through the frequency map
        for (int num : frequencyMap.keySet()) {
            // Check if there is a number with a frequency of num + 1
            if (frequencyMap.containsKey(num + 1)) {
                int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                longestSubsequenceLength = Math.max(longestSubsequenceLength, currentLength);
            }
        }
        
        return longestSubsequenceLength;
    }
}
