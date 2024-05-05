import java.util.*;

public class CoinCombination {

    public boolean constraintsCheck(int[] coins, int amount) {
        try {
            if (coins.length >= 1 && coins.length <= 12 && amount >= 0 && amount <= Math.pow(10, 4)) {
                for (int coin : coins) {
                    if (coin < 1 || coin > Integer.MAX_VALUE) {
                        throw new Exception("Invalid Input: Coin value out of range");
                    }
                }
            } else {
                throw new Exception("Invalid Input: Array length or amount out of range");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public int coinChange(int[] coins, int amount) {
        if (!constraintsCheck(coins, amount)) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> coinMap = new HashMap<>();
        queue.add(0);
        coinMap.put(0, 0);
        while (!queue.isEmpty()) {
            int currentAmount = queue.remove();
            for (int coin : coins) {
                int nextAmount = currentAmount + coin;
                if (nextAmount == amount) {
                    return coinMap.get(currentAmount) + 1;
                }
                if (nextAmount < amount && !coinMap.containsKey(nextAmount)) {
                    queue.add(nextAmount);
                    coinMap.put(nextAmount, coinMap.get(currentAmount) + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = 0;
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        CoinCombination ccOB = new CoinCombination();
        result = ccOB.coinChange(coins1, amount1);

        if (result != Integer.MAX_VALUE)
        System.out.println("Minimum number of coins for amount 11: " + result);

        int[] coins2 = {2};
        int amount2 = 3;
        result = ccOB.coinChange(coins2, amount2);

        if (result != Integer.MAX_VALUE)
        System.out.println("Minimum number of coins for amount 3: " + result);

        int[] coins3 = {1};
        int amount3 = 0;
        result = ccOB.coinChange(coins3, amount3);

        if (result != Integer.MAX_VALUE)
        System.out.println("Minimum number of coins for amount 0: " + result);
    }
}

