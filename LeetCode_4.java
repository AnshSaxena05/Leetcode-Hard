import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0)
        return 0;
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(Arrays.stream(nums2).boxed().toArray(Integer[]::new)));

        arr1.addAll(arr2);
        Collections.sort(arr1);
        int size= arr1.size();
        if(size%2==0)
        {
            int middle= arr1.get(size/2);
            int middle2= arr1.get((size/2) - 1);
            return (double) (middle2+middle)/2;
            
        }
        else
        {
            return arr1.get(size/2);
        }
    }
    public static void main(String[] args) {
        LeetCode_4 solution = new LeetCode_4();

        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result1 = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Test Case 1: " + result1);

        // Test case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double result2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println("Test Case 2: " + result2);
    }
}
