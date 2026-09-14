public class Task5MaxArea {

    public static long maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        long best = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int low = height[left];
            if (height[right] < low) {
                low = height[right];
            }

            long width = right - left;
            long area = width * low;
            if (area > best) {
                best = area;
            }

            if (height[left] < height[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 1};

        System.out.println("[1, 8, 6, 2, 5, 4, 8, 3, 7] -> " + maxArea(height1) + "   (ожидается 49)");
        System.out.println("[1, 1]                      -> " + maxArea(height2) + "   (ожидается 1)");
    }
}
