package max_points_on_a_line;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MaxPointsonaLine {

    public class Solution {

        private class Line {
            Point p1;
            Point p2;

            Line(Point p1, Point p2) {
                this.p1 = p1;
                this.p2 = p2;
            }
        }

        private boolean isOnTheSameLine(Point p1, Point p2, Point p3) {
            return (p3.y - p2.y) * (p2.x - p1.x) == (p3.x - p2.x)
                    * (p2.y - p1.y);
        }

        public int maxPoints(Point[] points) {
            List<Line> lines = new ArrayList<Line>();
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i].x != points[j].x
                            || points[i].y != points[j].y) {
                        lines.add(new Line(points[i], points[j]));
                    }
                }
            }
            if (lines.size() == 0) {
                return points.length;
            }
            int[] counts = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                Line line = lines.get(i);
                for (Point point : points) {
                    if (isOnTheSameLine(line.p1, line.p2, point)) {
                        counts[i]++;
                    }
                }
            }
            int max = counts[0];
            for (int i = 1; i < counts.length; i++) {
                max = Math.max(max, counts[i]);
            }
            return max;
        }
    }

    public static class UnitTest {

    }
}
