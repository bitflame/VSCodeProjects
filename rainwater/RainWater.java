
public class RainWater {
    public int trap(int[] height) {
        // do a loop and find the index of maxHeight, then another loop to approach it
        // from either side and add the difference in height of each bar with the one
        // just before it
        int current = 0, total = 0, maximumHeightIndex = 0, maximumPrevious = 0;
        maximumHeightIndex = maximumHeight(height, 0, height.length - 1);
        while (current < maximumHeightIndex) {
            if (maximumPrevious < height[current])
                maximumPrevious = height[current];
            if (height[current] < maximumPrevious) {
                total += maximumPrevious - height[current];
            }
            current++;
        }
        while (maximumHeightIndex < height.length - 2) {
            current = maximumHeightIndex ;
            maximumHeightIndex = maximumHeight(height, maximumHeightIndex + 1, height.length - 1);
            maximumPrevious = 0;
            while (current < maximumHeightIndex) {
                if (height[current] < height[maximumHeightIndex]) {
                    total += height[maximumHeightIndex] - height[current];
                }
                current++;
            }
        }
        return total;
    }

    private int maximumHeight(int[] height, int from, int to) {
        // returns index of maximum height
        int i = from, maxHeightIndex = 0, maxHeight = 0;
        while (i <= to) {
            if (height[i] >= maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
            i++;
        }
        return maxHeightIndex;
    }

    public int trapp(int[] height) {
        int current = 1, lo = 0, loMax = 0, highMax = 0, hi = 0, nextHi = 0, diff = 0, total = 0;
        while (hi < height.length - 1) {
            if (height[hi] > highMax)
                highMax = height[hi];
            hi++;
        }
        while (current < height.length - 1) {
            if (height[current] > loMax) {
                loMax = height[current];
                lo = current;
            }
            // if nextHi is less than loMax and highMax I should not use nextHi to calculate
            // the water

            nextHi = current;
            while (height[nextHi] < height[nextHi + 1]) {
                nextHi++;
            }
            if (nextHi > current) {
                for (int i = lo + 1; i < nextHi; i++) {
                    diff = Math.min(height[lo], height[nextHi]);
                    total += Math.abs(diff - height[i]);
                }
                lo = nextHi;
                if (height[lo] > loMax)
                    loMax = height[lo];
                if (current == nextHi)
                    current++;
                else
                    current = nextHi + 1;
            } else {
                current++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        RainWater rainWater = new RainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Test 1 - Expecting 6, Getting: " + rainWater.trap(height));
        rainWater = new RainWater();
        height = new int[] { 0, 1, 0, 3, 1, 0, 1, 2, 2, 1, 2, 1 };
        System.out.println("Test 2 - Expecting 6, Getting: " + rainWater.trap(height));
        rainWater = new RainWater();
        height = new int[] { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 };
        System.out.println("Test 3 - Expecting 23, Getting: " + rainWater.trap(height));
        height = new int[] { 4, 2, 0, 3, 2, 4, 3, 4 };
        rainWater = new RainWater();
        System.out.println("Test 4 - Expecting 10, Getting: " + rainWater.trap(height));
        height = new int[] { 4, 2, 0, 3, 2, 5 };
        rainWater = new RainWater();
        System.out.println("Test 5 - Expecting 9, Getting: " + rainWater.trap(height));
        height = new int[] { 2, 0, 2 };
        rainWater = new RainWater();
        System.out.println("Test 6 - Expecting 2, Getting: " + rainWater.trap(height));
        height = new int[] { 5, 4, 1, 2 };
        rainWater = new RainWater();
        System.out.println("Test 7 - Expecting 1, Getting: " + rainWater.trap(height));
    }
}