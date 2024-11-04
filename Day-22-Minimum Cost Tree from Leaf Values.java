class Solution {

    public int mctFromLeafValues(int[] arr) {
        int size = arr.length; 
        int[][] dp = new int[size][size]; // Create a DP array to store minimum cost
        int[][] maxLeafValue = new int[size][size]; // Create an array to store max leaf value in the subarray [i...j]
      
        // Fill the maxLeafValue array by iterating from the end to the beginning
        // The value maxLeafValue[i][j] represents the maximum leaf value in the subarray arr[i...j]
        for (int i = size - 1; i >= 0; --i) {
            maxLeafValue[i][i] = arr[i]; // A single leaf's max value is itself
            for (int j = i + 1; j < size; ++j) {
                maxLeafValue[i][j] = Math.max(maxLeafValue[i][j - 1], arr[j]);
                dp[i][j] = Integer.MAX_VALUE; // Initialize the DP array with max values
              
                // Compute the minimum cost for subarray [i...j] by trying out all possible partitions
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], 
                                         dp[i][k] + dp[k + 1][j] + maxLeafValue[i][k] * maxLeafValue[k + 1][j]);
                }
            }
        }

        // Return the final answer, which is the minimum cost for the whole array
        return dp[0][size - 1];
    }
}
