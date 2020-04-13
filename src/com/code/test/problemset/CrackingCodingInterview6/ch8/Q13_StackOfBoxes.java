package com.code.test.problemset.CrackingCodingInterview6.ch8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Stack of Boxes:
 * You have a stack of n boxes, with widths w1, heights hi, and depths di.
 * The boxes cannot be rotated and can only be stacked on top of one another if each box
 * in the stack is strictly larger than the box above it in width, height, and depth.
 * Implement a method to compute the height of the tallest possible stack.
 * The height of a stack is the sum of the heights of each box.
 */
public class Q13_StackOfBoxes {

    public static void main(String[] args) {
        Box[] boxList = {new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = createStack(boxes);
        System.out.println(height);
    }

    public static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, (x, y) -> y.height - x.height);

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    public static int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }

    static class Box {
        public int width;
        public int height;
        public int depth;

        public Box(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }

        public boolean canBeUnder(Box b) {
            if (width > b.width && height > b.height && depth > b.depth) {
                return true;
            }
            return false;
        }

        public boolean canBeAbove(Box b) {
            if (b == null) {
                return true;
            }
            if (width < b.width && height < b.height && depth < b.depth) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Box(" + width + "," + height + "," + depth + ")";
        }
    }
}
