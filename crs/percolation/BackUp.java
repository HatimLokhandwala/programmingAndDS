
public class BackUp {
    public static void main(String[] args) {
        // ArrayList<LineSegment> lines = new ArrayList<>();
        // Point[] temp = Arrays.copyOf(points, points.length);
        // int n = points.length;
        // for (int i = 0; i < points.length; i++) {
        //     Arrays.sort(temp, points[i].slopeOrder());
        //     Point min = points[i];
        //     Point max = points[i];
        //     int count = 2;
        //     for (int j = 0; j < n - 1; j++) {
        //         if (points[i].slopeTo(temp[j]) == points[i].slopeTo(temp[j+1])) {
        //             if (temp[j+1].compareTo(max) > 0) {
        //                 max = temp[j + 1];
        //             }
        //             else if (temp[j+1].compareTo(min) < 0) {
        //                 min = temp[j + 1];
        //             }
        //             count++;
        //             if (j == n - 2 && count >= 4 && points[i].compareTo(min) == 0) {
        //                 lines.add(new LineSegment(min, max));
        //             }
        //         }
        //         else {
        //             if (count >= 4 && points[i].compareTo(min) == 0) {
        //                 lines.add(new LineSegment(min, max));
        //             }
        //             if (points[i].compareTo(temp[j+1]) > 0) {
        //                 max = points[i];
        //                 min = temp[j+1];
        //                 count = 2;
        //             }
        //             else {
        //                 max = temp[j+1];
        //                 min = points[i];
        //                 count = 2;
        //             }
        //         }
        //     }

        // My sOlution

        // List<LineSegment> list = new ArrayList<>();
        // LineSegment[] lineSegmentArr;
        // for (int i = 0; i < points.length; i++) {
        //     Point p = points[i];
        //     Point[] copy = new Point[points.length];
        //     System.arraycopy(points, 0, copy, 0, points.length);
        //     Arrays.sort(copy, p.slopeOrder());
        //     Double prevSlope = 0.0;
        //     LinkedList<Point> currentPoints = new LinkedList<>();
        //     for (int j = 0; j < copy.length; j++) {
        //         Point current = copy[j];
        //         Double currentSlope = p.slopeTo(current);
        //         if (j == 0 || prevSlope.compareTo(currentSlope) != 0) {
        //              if (currentPoints.size() >= 3) {
        //                 currentPoints.add(p);
        //                 Collections.sort(currentPoints);
        //                 LineSegment lineSegment = new LineSegment(currentPoints.getFirst(), currentPoints.getLast());
        //                 list.add(lineSegment);
        //             }
        //             currentPoints.clear();
        //         }
        //         prevSlope = currentSlope;
        //         currentPoints.add(current);
        //     }
        // }
        //
        // lineSegmentArr = new LineSegment[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     lineSegmentArr[i] = list.get(i);
        // }
        // return lineSegmentArr;
        //Iteratre through array
        // sort on compare to with pivot
        // pick points with same slope
        //add all points in the line segement
        }
    }

