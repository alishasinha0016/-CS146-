import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums, 0, nums.length -1); //sorting the passed parameter, array nums using merge sort
        int n = nums.length;
        int target = 0, left_Index = 0, right_Index = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {// Here, we will be skipping the same or duplicate elements
                continue;
            }
            target = -nums[i]; // assign the value to target as the negative of nums[i]
          // here we are assigning values to the two pointers,left_Index and right_Index
            left_Index = i + 1;
            right_Index = n - 1;
            while (left_Index < right_Index) {
                if (nums[right_Index] + nums[left_Index] == target) { // if we find the sum that equals target, we will add the numbers in the list
                    result.add(Arrays.asList(nums[i], nums[left_Index], nums[right_Index]));
                    left_Index++;
                    right_Index--;
                  // if we find a duplicate, we skip it by updating left_Index value
                    while (left_Index < right_Index && nums[left_Index] == nums[left_Index - 1]) {
                        left_Index++;
                    }
                  // if we find a duplicate, we skip it by updating right_Indes value
                    while (left_Index < right_Index && nums[right_Index] == nums[right_Index + 1]) {
                        right_Index--;
                    }
                  // if the sum is less than target then we update the left_Index else we update right_Index
                } else if (nums[right_Index] + nums[left_Index] < target) {
                    left_Index++;
                } else {
                    right_Index--;
                }
            }
        }

        return result; 
    }

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums1 = {0, 1, 1};
        int[] nums2 = {-5, 0, 5, 10, -10, 0};

        System.out.println(threeSum.threeSum(nums1));  
        System.out.println(threeSum.threeSum(nums2));  
}
  

