package snake_game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 1/25/18.
 */
public class DesignSnakeGame {

    public class Solution {

        public class SnakeGame {

            private int width, height, score;
            private List<int[]> food = new ArrayList<>();
            private List<int[]> pos = new ArrayList<>();

            public void SnakeGame(int width, int height, List<int[]> food) {
                this.width = width;
                this.height = height;
                this.food = food;
                score = 0;
                pos.add(new int[] {0, 0});
            }

            public int move(String direction) {
                int[] head = pos.get(0), tail = pos.get(pos.size()-1);
                pos.remove(pos.size()-1);
                if (direction == "U") --head[0];
                else if (direction == "L") --head[1];
                else if (direction == "R") ++head[1];
                else if (direction == "D") ++head[0];
                if (count(pos, head) > 0 || head[0] < 0 || head[0] >= height || head[1] < 0 || head[1] >= width) {
                    return -1;
                }
                pos.add(0, head);
                if (food.size() != 0  && head == food.get(0)) {
                    food.remove(0);
                    pos.add(tail);
                    ++score;
                }
                return score;
            }

            private int count(List<int[]> pos, int[] head) {
                int count = 0;
                for (int[] a : pos) {
                    if (a == head) count++;
                }
                return count;
            }

        }

    }

    public static class UnitTest {


    }


}
