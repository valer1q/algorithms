import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class Task5SubarraySum {

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

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        long k = (long) in.nval;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }

        System.out.println(countSubarrays(nums, k));
    }
}
