import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Task4ShipCapacity {

    public static long minCapacity(int[] weights, int days) {
        if (weights == null || weights.length == 0) {
            return 0;
        }

        long lo = 0;
        long hi = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > lo) {
                lo = weights[i];
            }
            hi = hi + weights[i];
        }

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (daysNeeded(weights, mid) <= days) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static int daysNeeded(int[] weights, long capacity) {
        int days = 1;
        long load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days = days + 1;
                load = weights[i];
            } else {
                load = load + weights[i];
            }
        }

        return days;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int days = (int) in.nval;

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            weights[i] = (int) in.nval;
        }

        System.out.println(minCapacity(weights, days));
    }
}
