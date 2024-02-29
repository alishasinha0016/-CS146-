class LongestPalindrome:
    def longestPalindrome(self, s) -> int:
        if 1 <= len(s) <= 2000 and s.isalpha():
            map_Palin = {}
            s_palin1 = ""
            s_palin2 = ""
            ch = ''
            for ch in s:
                if ch in map_Palin:
                    map_Palin[ch] += 1
                else:
                    map_Palin[ch] = 1
            ch = ' '
            for key, value in map_Palin.items():
                i = value // 2
                for j in range(i):
                    s_palin1 += key
                    s_palin2 = key + s_palin2
                if ch == ' ' and value % 2 != 0:
                    ch = key
            if ch !=' ':
                return len(s_palin1 + ch + s_palin2)
            else:
                return len(s_palin1 + s_palin2)

        else:
            return -1

    def main(self):
        s = input('Enter your first input:')
        result = self.longestPalindrome(s)
        if result != -1:
            print(result)
        else:
            print("Invalid Entry")


if __name__ == "__main__":
    palinOb = LongestPalindrome()
    palinOb.main()
