public class Task6MinWindow {

    public static String minWindow(String source, String target) {
        if (source == null || target == null) {
            return "";
        }
        if (target.length() == 0 || target.length() > source.length()) {
            return "";
        }

        int[] need = new int[128];
        int required = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (need[c] == 0) {
                required = required + 1;
            }
            need[c] = need[c] + 1;
        }

        int[] window = new int[128];
        int formed = 0;
        int left = 0;
        int bestLen = -1;
        int bestStart = 0;

        for (int right = 0; right < source.length(); right++) {
            char c = source.charAt(right);
            window[c] = window[c] + 1;
            if (need[c] > 0 && window[c] == need[c]) {
                formed = formed + 1;
            }

            while (formed == required) {
                int length = right - left + 1;
                if (bestLen == -1 || length < bestLen) {
                    bestLen = length;
                    bestStart = left;
                }

                char d = source.charAt(left);
                left = left + 1;
                window[d] = window[d] - 1;
                if (need[d] > 0 && window[d] < need[d]) {
                    formed = formed - 1;
                }
            }
        }

        if (bestLen == -1) {
            return "";
        }
        return source.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        System.out.println("\"ADOBECODEBANC\", \"ABC\" -> \"" + minWindow("ADOBECODEBANC", "ABC") + "\"   (ожидается \"BANC\")");
        System.out.println("\"a\", \"aa\"              -> \"" + minWindow("a", "aa") + "\"   (ожидается \"\")");
        System.out.println("\"AAABBC\", \"AABC\"       -> \"" + minWindow("AAABBC", "AABC") + "\"   (ожидается \"AABBC\")");
    }
}
