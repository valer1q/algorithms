import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Task2RangeSum {

    public static long[] buildPrefix(int[] nums) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    public static long rangeSum(long[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }

        long[] prefix = buildPrefix(nums);

        in.nextToken();
        int q = (int) in.nval;

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            in.nextToken();
            int left = (int) in.nval;
            in.nextToken();
            int right = (int) in.nval;

            out.append(rangeSum(prefix, left, right));
            out.append("\n");
        }

        System.out.print(out);
    }
}
