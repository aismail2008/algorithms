package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * Master Mind:
 * The G ame of Master Mind is played as follows:
 * The computer has four slots, and each slot will contain a ball that is red (R), yellow (Y), green (G) or
 * blue (B). For example, the computer might have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot
 * #4 is blue).
 * You, the user, are trying to guess the solution. You might, for example, guess YRGB.
 * When you guess the correct color for the correct slot, you get a "hit:' If you guess a color that exists
 * but is in the wrong slot, you get a "pseudo-hit:' Note that a slot that is a hit can never count as a
 * pseudo-hit.
 * <p>
 * For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-
 * hit
 * <p>
 * Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
 */
public class Q15_MasterMind {
    class Result {
        public int hits = 0;
        public int pseudoHits = 0;

        public String toString() {
            return "(" + hits + ", " + pseudoHits + ")";
        }
    }

    int code(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }

    int MAX_COLORS = 4;

    Result estimate(String guess, String solution) {
        if (guess.length() != solution.length())
            return null;

        Result res = new Result();
        int[] frequencies = new int[MAX_COLORS];

        /* Compute hits and build frequency table */
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
               /* Only increment the frequency table (which will be used for pseudo-hits)
               if it's not a hit. If it's a hit, the slot has already been "used." */
                int code = code(solution.charAt(i));
                frequencies[code]++;
            }
        }

        /* Compute pseudo-hits */
        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 &&
                    guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHits++;
                frequencies[code]--;
            }
        }
        return res;
    }
}
