/*
You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) 
to roll the dice so the sum of the face-up numbers equals target. Since the answer may be too large, 
return it modulo 10^9 + 7.
*/

class Solution {
  public int numRollsToTarget(int n, int k, int target) {

    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;

    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= k; j++) {
        for(int l = target; l >= j; l--) {
          if(dp[i - 1][l - j] > 0) {
              dp[i][l] += dp[i - 1][l - j];
              dp[i][l] = dp[i][l] % 1000000007;
          }
        }
      }
    }
    return dp[n][target];
  }
}
