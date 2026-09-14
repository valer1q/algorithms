import java.util.HashMap;

public class Task4SubarraySum {

    public static long countSubarrays(int[] nums, long k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Long, Integer> seen = new HashMap<Long, Integer>();
        seen.put(0L, 1);

        long prefix = 0;
        long answer = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix = prefix + nums[i];

            long wanted = prefix - k;
            if (seen.containsKey(wanted)) {
                answer = answer + seen.get(wanted);
            }

            if (seen.containsKey(prefix)) {
                seen.put(prefix, seen.get(prefix) + 1);
            } else {
                seen.put(prefix, 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, -1, 0};

        System.out.println("[1, 1, 1],  k = 2 -> " + countSubarrays(nums1, 2) + "   (ожидается 2)");
        System.out.println("[1, -1, 0], k = 0 -> " + countSubarrays(nums2, 0) + "   (ожидается 3)");
    }
}
