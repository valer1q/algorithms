import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Task3MergeIntervals {

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval other) {
            if (this.start < other.start) {
                return -1;
            }
            if (this.start > other.start) {
                return 1;
            }
            return 0;
        }
    }

    public static Interval[] merge(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new Interval[0];
        }

        Interval[] a = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            a[i] = intervals[i];
        }
        Arrays.sort(a);

        Interval[] buffer = new Interval[a.length];
        int size = 0;

        int curStart = a[0].start;
        int curEnd = a[0].end;

        for (int i = 1; i < a.length; i++) {
            if (a[i].start <= curEnd) {
                if (a[i].end > curEnd) {
                    curEnd = a[i].end;
                }
            } else {
                buffer[size] = new Interval(curStart, curEnd);
                size = size + 1;
                curStart = a[i].start;
                curEnd = a[i].end;
            }
        }

        buffer[size] = new Interval(curStart, curEnd);
        size = size + 1;

        Interval[] result = new Interval[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[i];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;

        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int start = (int) in.nval;
            in.nextToken();
            int end = (int) in.nval;
            intervals[i] = new Interval(start, end);
        }

        Interval[] merged = merge(intervals);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < merged.length; i++) {
            out.append(merged[i].start);
            out.append(" ");
            out.append(merged[i].end);
            out.append("\n");
        }

        System.out.print(out);
    }
}
