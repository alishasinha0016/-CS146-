from typing import List


class ThreeSum:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        self.mergeSort(nums) #sorting the passed parameter, array nums, using merge sort
        n = len(nums)
        result = []

        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]: #// Here, we will be skipping the same or duplicate elements
                continue
            target = -nums[i] # assign the value to target as the negative of nums[i]
            #here we are assigning values to the two pointers,left_Index and right_Index
            left_index = i + 1
            right_index = n - 1
            while left_index < right_index:
                if nums[right_index] + nums[left_index] == target: #if we find the sum that equals target, we will append the numbers in the list
                    result.append([nums[i], nums[left_index], nums[right_index]])
                    left_index += 1
                    right_index -= 1
                    #if we find a duplicate, we skip it by updating left_index value
                    while left_index < right_index and nums[left_index] == nums[left_index - 1]:
                        left_index += 1
                    #if we find a duplicate, we skip it by updating right_index value
                    while left_index < right_index and nums[right_index] == nums[right_index + 1]:
                        right_index -= 1
                    #if the sum is less than target then we update the left_index else we update right_index
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

