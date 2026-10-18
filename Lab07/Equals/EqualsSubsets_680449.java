package Lab07.pack;
public class EqualsSubsets_680449 {
    public boolean canPartition_Recurse(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 2 != 0) return false;
        return canPartition_Recurse(arr, 0, total / 2);
    }

    private boolean canPartition_Recurse(int[] arr, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index >= arr.length || sum < 0) {
            return false;
        }
        return canPartition_Recurse(arr, index + 1, sum - arr[index])
                || canPartition_Recurse(arr, index + 1, sum);
    }

    public boolean canPartition_Memoiz(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 2 != 0) return false;
        Boolean[][] memo = new Boolean[arr.length][total / 2 + 1];
        return canPartition_Memoiz(arr, 0, total / 2, memo);
    }

    private boolean canPartition_Memoiz(int[] arr, int index, int sum, Boolean[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (index >= arr.length || sum < 0) {
            return false;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        boolean result = canPartition_Memoiz(arr, index + 1, sum - arr[index], memo)
                || canPartition_Memoiz(arr, index + 1, sum, memo);

        memo[index][sum] = result;
        return result;
    }

    public boolean canPartition_DP(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 2 != 0) return false;
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 
        for (int num : arr) {
            for (int s = target; s >= num; s--) {
                if (dp[s - num]) {
                    dp[s] = true;
                }
            }
        }
        return dp[target];
    }
    void toString_backdoor() {
    }
}
