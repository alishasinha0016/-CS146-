from typing import List


class ThreeSum:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        self.mergeSort(nums)
        n = len(nums)
        result = []

        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            target = -nums[i]
            left_index = i + 1
            right_index = n - 1
            while left_index < right_index:
                if nums[right_index] + nums[left_index] == target:
                    result.append([nums[i], nums[left_index], nums[right_index]])
                    left_index += 1
                    right_index -= 1
                    while left_index < right_index and nums[left_index] == nums[left_index - 1]:
                        left_index += 1
                    while left_index < right_index and nums[right_index] == nums[right_index + 1]:
                        right_index -= 1
                elif nums[left_index] + nums[right_index] < target:
                    left_index += 1
                else:
                    right_index -= 1

        return result

    def mergeSort(self, arr):
        if len(arr) > 1:

            # Finding the mid of the array
            mid = len(arr) // 2

            # Dividing the array elements
            L = arr[:mid]

            # Into 2 halves
            R = arr[mid:]

            # Sorting the first half
            self.mergeSort(L)

            # Sorting the second half
            self.mergeSort(R)

            i = j = k = 0

            # Copy data to temp arrays L[] and R[]
            while i < len(L) and j < len(R):
                if L[i] <= R[j]:
                    arr[k] = L[i]
                    i += 1
                else:
                    arr[k] = R[j]
                    j += 1
                k += 1

            # Checking if any element was left
            while i < len(L):
                arr[k] = L[i]
                i += 1
                k += 1

            while j < len(R):
                arr[k] = R[j]
                j += 1
                k += 1


def main():
    nums1 = [0, 1, 1]
    nums2 = [-5, 0, 5, 10, -10, 0]

    three_sum = ThreeSum()
    print(three_sum.threeSum(nums1))
    print(three_sum.threeSum(nums2))


if __name__ == "__main__":
    main()

