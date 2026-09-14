import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a);

        int n = a.length;
        for (int i = 0; i < n - 2; i++) {
            if (a[i] > 0) {
                break;
            }
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }

            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int sum = a[i] + a[lo] + a[hi];

                if (sum < 0) {
                    lo = lo + 1;
                } else if (sum > 0) {
                    hi = hi - 1;
                } else {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(a[i]);
                    triple.add(a[lo]);
                    triple.add(a[hi]);
                    result.add(triple);

                    while (lo < hi && a[lo] == a[lo + 1]) {
                        lo = lo + 1;
                    }
                    while (lo < hi && a[hi] == a[hi - 1]) {
                        hi = hi - 1;
                    }

                    lo = lo + 1;
                    hi = hi - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0, 0};
        int[] nums3 = {1, 2, -2, -1};

        System.out.println("[-1, 0, 1, 2, -1, -4] -> " + threeSum(nums1) + "   (ожидается [[-1, -1, 2], [-1, 0, 1]])");
        System.out.println("[0, 0, 0, 0]          -> " + threeSum(nums2) + "   (ожидается [[0, 0, 0]])");
        System.out.println("[1, 2, -2, -1]        -> " + threeSum(nums3) + "   (ожидается [])");
    }
}
