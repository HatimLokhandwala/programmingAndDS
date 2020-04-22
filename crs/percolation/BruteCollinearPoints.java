/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BruteCollinearPoints {
    private final Point[] pArr;
    private List<LineSegment> list;
    public BruteCollinearPoints(Point[] points) {
        pArr = new Point[points.length];
        System.arraycopy(points, 0, pArr, 0, points.length);
        checkPoints(pArr);
        int len = pArr.length;
        list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int p = k + 1; p < len; p++) {
                        Double slope1 = pArr[i].slopeTo(pArr[j]);
                        Double slope2 = pArr[j].slopeTo(pArr[k]);
                        if (slope1.compareTo(slope2) != 0) {
                            continue;
                        }

                        Double slope3 = pArr[k].slopeTo(pArr[p]);
                        if (slope2.compareTo(slope3) != 0) {
                            continue;
                        }
                        Point[] temp = {pArr[i], pArr[j], pArr[k], pArr[p]};
                        Arrays.sort(temp, Point::compareTo);
                        LineSegment lineSegment = new LineSegment(temp[0], temp[3]);
                        list.add(lineSegment);
                    }
                }
            }
        }
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
        LineSegment[] lineSegmentArr = new LineSegment[list.size()];
        return list.toArray(lineSegmentArr);
    }

    public static void main(String[] args) {
        // empty method body
    }
}
