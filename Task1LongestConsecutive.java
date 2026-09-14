import java.util.HashSet;

public class Task1LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int best = 0;
        for (int x : set) {
            if (set.contains(x - 1)) {
                continue;
            }

            int length = 1;
            int cur = x;
            while (set.contains(cur + 1)) {
                cur = cur + 1;
                length = length + 1;
            }

            if (length > best) {
                best = length;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {};

        System.out.println("[100, 4, 200, 1, 3, 2]         -> " + longestConsecutive(nums1) + "   (ожидается 4)");
        System.out.println("[0, 3, 7, 2, 5, 8, 4, 6, 0, 1] -> " + longestConsecutive(nums2) + "   (ожидается 9)");
        System.out.println("[]                             -> " + longestConsecutive(nums3) + "   (ожидается 0)");
    }
}
