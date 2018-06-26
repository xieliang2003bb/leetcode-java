package smallest_rectangle_enclosing_black_pixels;

/**
 * Created by lxie on 6/26/18.
 */
public class MinArea {

    public class Solution {

        public int minArea(char[][] image, int x, int y) {
            int[] left = {y}; int[] right = {y};
            int[] up = {x}; int[] down = {x};
            dfs(image, x, y, left, right, up, down);
            return (right[0] - left[0] + 1) * (down[0] - up[0] + 1);
        }

        private void dfs(char[][] image, int x, int y, int[] left,
                         int[] right, int[] up, int[] down) {
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length ||
                    image[x][y] != '1') return;
            left[0] = Math.min(left[0], y);
            right[0] = Math.max(right[0], y);
            up[0] = Math.min(up[0], x);
            down[0] = Math.max(down[0], x);
            image[x][y] = '2';
            dfs(image, x + 1, y, left, right, up, down);
            dfs(image, x - 1, y, left, right, up, down);
            dfs(image, x, y + 1, left, right, up, down);
            dfs(image, x, y - 1, left, right, up, down);
        }


    }

    public class UnitTest {


    }


}
