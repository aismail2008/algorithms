package com.code.test.problemset.CrackingCodingInterview6.ch16;


/**
 * Bisect Squares:
 * Given two squares on a two-dimensional plane, find a line that would cut these two
 * squares in half. Assume that the top and the bottom sides of the square run parallel to the x-axis.
 */
public class Q13_BisectSquares {

    static class Point {
        Double x, y;

        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point point1;
        Point point2;

        public Line(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }
    }

    static class Square {
        public double left;
        public double top;
        public double bottom;
        public double right;

        public Square(double left, double top, double size) {
            this.left = left;
            this.top = top;
            this.bottom = top + size;
            this.right = left + size;
        }


        public Point middle() {
            return new Point((this.left + this.right) / 2,
                    (this.top + this.bottom) / 2);
        }

        public Line cut(Square other) {
            Point middle_s = this.middle();
            Point middle_t = other.middle();

            if (middle_s.equals(middle_t)) {
                return new Line(new Point(left, top),
                        new Point(right, bottom));
            } else {
                return new Line(middle_s, middle_t);
            }
        }
    }
}
