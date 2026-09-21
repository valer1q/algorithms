import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Task6MeetingRooms {

    public static int minRooms(int[] starts, int[] ends) {
        if (starts == null || starts.length == 0) {
            return 0;
        }

        int n = starts.length;
        int[] s = new int[n];
        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = starts[i];
            e[i] = ends[i];
        }
        Arrays.sort(s);
        Arrays.sort(e);

        int rooms = 0;
        int best = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && e[j] <= s[i]) {
                rooms = rooms - 1;
                j = j + 1;
            }
            rooms = rooms + 1;
            if (rooms > best) {
                best = rooms;
            }
        }

        return best;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            starts[i] = (int) in.nval;
            in.nextToken();
            ends[i] = (int) in.nval;
        }

        System.out.println(minRooms(starts, ends));
    }
}
