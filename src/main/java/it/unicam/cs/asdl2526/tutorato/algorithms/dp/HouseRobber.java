package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

/**
 * Trova il bottino massimo ottenibile scegliendo case non adiacenti in una fila.
 */
public final class HouseRobber {

    private HouseRobber() {
    }

    /**
     * I valori delle case sono non negativi e il risultato è rappresentabile come int.
     *
     * @param nums valore delle case, nell'ordine in cui si trovano nella fila
     * @return il bottino massimo oppure 0 se la fila è vuota
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
