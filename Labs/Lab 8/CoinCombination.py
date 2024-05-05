import sys
class CoinCombination:
    def constraints_check(self, coins, amount):
        try:
            if not (1 <= len(coins) <= 12 and 0 <= amount <= 10 ** 4):
                raise Exception("Invalid Input: Array length or amount out of range")
            for coin in coins:
                if coin < 1 or coin > 2 ** 31 - 1:
                    raise Exception("Invalid Input: Coin value out of range")
        except Exception as e:
            print(e)
            return False
        return True

    def coin_change(self, coins, amount):
        if not self.constraints_check(coins, amount):
            return sys.maxsize
        if amount == 0:
            return 0
        coin_map = {0: 0}
        queue = [0]
        while queue:
            current_amount = queue.pop(0)
            for coin in coins:
                next_amount = current_amount + coin
                if next_amount == amount:
                    return coin_map[current_amount] + 1
                if next_amount < amount and next_amount not in coin_map:
                    queue.append(next_amount)
                    coin_map[next_amount] = coin_map[current_amount] + 1
        return -1

    def main(self):
        coins1 = [1, 2, 5]
        amount1 = 11
        result = self.coin_change(coins1, amount1)
        if result != sys.maxsize:
            print(f"Minimum number of coins for amount {amount1}: {result}")

        coins2 = [2]
        amount2 = 3
        result = self.coin_change(coins2, amount2)
        if result != sys.maxsize:
            print(f"Minimum number of coins for amount {amount2}: {result}")

        coins3 = [1]
        amount3 = 0
        result = self.coin_change(coins3, amount3)
        if result != sys.maxsize:
            print(f"Minimum number of coins for amount {amount3}: {result}")


if __name__ == "__main__":
    ccOB = CoinCombination()
    ccOB.main()


