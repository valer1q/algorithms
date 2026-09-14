import java.util.HashMap;

public class Task3TwoTypes {

    public static int maxItems(int[] items) {
        if (items == null || items.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        int best = 0;
        int left = 0;

        for (int right = 0; right < items.length; right++) {
            int type = items[right];
            if (count.containsKey(type)) {
                count.put(type, count.get(type) + 1);
            } else {
                count.put(type, 1);
            }

            while (count.size() > 2) {
                int leftType = items[left];
                int rest = count.get(leftType) - 1;
                if (rest == 0) {
                    count.remove(leftType);
                } else {
                    count.put(leftType, rest);
                }
                left = left + 1;
            }

            int length = right - left + 1;
            if (length > best) {
                best = length;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] items1 = {1, 2, 1};
        int[] items2 = {0, 1, 2, 2};
        int[] items3 = {1, 2, 3, 2, 2};

        System.out.println("[1, 2, 1]       -> " + maxItems(items1) + "   (ожидается 3)");
        System.out.println("[0, 1, 2, 2]    -> " + maxItems(items2) + "   (ожидается 3)");
        System.out.println("[1, 2, 3, 2, 2] -> " + maxItems(items3) + "   (ожидается 4)");
    }
}
