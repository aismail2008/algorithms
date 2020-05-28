package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * Intersection:
 * Given two straight line segments (represented as a start point and an end point),
 * compute the point of intersection, if any.
 * Line Equation is : Y = m X + b
 * m is the slope = (y2-y1) / (x2-x1)
 * b is y-intercept: y1 - m * x1
 */
public class Q3_Intersection {

    // Driver method
    public static void main(String args[]) {
        Point A = new Point(1, 1);
        Point B = new Point(2, 2);
        Point C = new Point(3, 3);
        Point D = new Point(4, 4);

        Point intersection = lineLineIntersectionAli(A, B, C, D);

        if (intersection.x == Double.MAX_VALUE &&
                intersection.y == Double.MAX_VALUE) {
            System.out.println("The given lines AB and CD are parallel.");
        } else {
            // NOTE: Further check can be applied in case
            // of line segments. Here, we have considered AB
            // and CD as lines
            System.out.print("The intersection of the given lines AB " +
                    "and CD is: ");
            Point.displayPoint(intersection);
        }
    }


    static Point lineLineIntersection(Point A, Point B, Point C, Point D) {
        // Line AB represented as a1x + b1y = c1
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1 * (A.x) + b1 * (A.y);

        // Line CD represented as a2x + b2y = c2
        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2 * (C.x) + b2 * (C.y);

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            return new Point(x, y);
        }
    }

    /**
     *  Line Equation is : Y = m X + b
     *  m is the slope = (y2-y1) / (x2-x1)
     *  b is y-intercept: y1 - m * x1
     */
    static Point lineLineIntersectionAli(Point A, Point B, Point C, Point D) {
        //  Line AB represented as y-y1 = sx-sx1
        double s1 = (B.y - A.y) / (B.x - A.x);
        double m1 = A.y - s1 * A.x; //


        double s2 = (D.y - C.y) / (D.x - C.x);
        double m2 = C.y - s2 * C.x;

        if (s1 == s2) {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            double x = (m2 - m1) / (s1 - s2);
            double y = s1 * x + m1;
            return new Point(x, y);
        }
    }

    static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Method used to display X and Y coordinates
        // of a point
        static void displayPoint(Point p) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
