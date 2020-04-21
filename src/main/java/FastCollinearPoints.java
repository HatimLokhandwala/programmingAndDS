/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FastCollinearPoints {
    private final Point[] points;

    public FastCollinearPoints(Point[] points) {
        checkPoints(points);
        this.points = new Point[points.length];
        System.arraycopy(points, 0, this.points, 0, points.length);
    }

    private void checkPoints(Point[] points) {
        if (Objects.isNull(points)) {
            throw new IllegalArgumentException("Points arr cannot be null");
        }
        for (Point point : points) {
            if (Objects.isNull(point)) {
                throw new IllegalArgumentException("Point cannot be null");
            }
        }
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.compareTo(p2) == 0) {
                    throw new IllegalArgumentException("Duplicate points");
                }
            }
        }
    }

    public int numberOfSegments() {
        return segments().length;
    }

    public LineSegment[] segments() {

        List<LineSegment> list = new ArrayList<>();
        int length = points.length;
        Arrays.sort(points);
        for (int i = 0; i < length; i++) {
            Point pivot = points[i];
            Point[] copy = new Point[length];
            System.arraycopy(points, 0, copy, 0, length);
            Arrays.sort(copy, pivot.slopeOrder());
            Double previousSlope = 0.0;
            List<Point> collinear = new ArrayList<>();
            for (int j = 1; j < length; j++) {
                Point current = copy[j];
                Double currentSlope = pivot.slopeTo(current);
                if (previousSlope.compareTo(currentSlope) != 0) {
                    int size = collinear.size();
                    if (size >= 3 && pivot.compareTo(collinear.get(0)) < 0) {
                        LineSegment ls = new LineSegment(pivot, collinear.get(size - 1));
                        list.add(ls);
                    }
                    collinear.clear();
                }
                previousSlope = currentSlope;
                collinear.add(current);
            }
            int size = collinear.size();
            if (size >= 3 && pivot.compareTo(collinear.get(0)) < 0) {
                LineSegment ls = new LineSegment(pivot, collinear.get(size - 1));
                list.add(ls);
            }
        }
        LineSegment[] lineSegmentArr = new LineSegment[list.size()];
        return list.toArray(lineSegmentArr);
    }

    public static void main(String[] args) {
        // empty method body
    }
}
