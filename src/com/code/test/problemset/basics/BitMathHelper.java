package com.code.test.problemset.basics;

public class BitMathHelper {

    /**
     * ^   : XOR 1 different 0 else
     * ~   : Not
     * >>  : shift without most significant bit
     * >>> : shift with most significant bit
     * -x: flip then add 1 => two's complement
     */

    /**
     *
     * 1 Terabyte = = 1 Trillion = 1,000,000,000,000 bytes = 10^12 byte
     * 1 GB = 1 billion = 1,000,000,000 bytes = 10^9 byte
     *
     *
     * https://www.aqua-calc.com/page/powers-of-two
     *
     * 1000 ~= 2^10
     * [Giga = 1000 Mega] [Mega = 1000 Kilo] [Kilo = 1000]
     * 1 Byte =                     2^3 bit
     * 1 KByte = 1000 byte =        2^13 bit
     * 1 MByte = 10^6 byte  =        2^23 bit
     * ------------------------
     *
     *  - Total of (1 + 2 + ... + n) =  n * (n+1)/2
     *  - Total of (2^0 + 2^1 + .. + s^n) = (2^(n+1)) - 1
     * of 2
     * ° + 2
     * 1 + 22 + ... + 2" would, in base 2, be a sequence of (n + 1) 1 s. This is 2n+1
     * - 1.
     */

    /**
     * Max number in byte ( 8 bits)    -128 <  val < 127
     * which is power(2,n-1) < val < power(2,n-1) -1
     */

    // This is 1010101010101010101010101010101
    int o1o1o1o1 = 0x55555555;
    // This is 10101010101010101010101010101010
    int o1o1o1o = 0xaaaaaaaa;

    int wordNumber = (32 >> 5); // divide by 32  == power(2,5)
    //0x1F == 31 == 11111
    int bitNumber = (32 & 0x1F); // mod 32


    /**
     * This method shifts 1 over by i bits,
     * creating a value that looks like 00010000.
     * By performing an AND with num, we clear all bits other than the bit at bit i.
     * Finally, we compare that to 0. If that new value is not zero, then bit i must have a 1. Otherwise, bit i is a 0.
     */
    boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    /**
     * Set 1 at bit i
     * <p>
     * Set Bit shifts 1 over by i bits, creating a value like 00010000. By performing an OR with num, only the
     * value at bit i will change. All other bits of the mask are zero and will not affect num.
     */
    int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * Clear Bit == set bit 0
     * This method operates in almost the reverse of setBit.
     * First, we create a number like 11101111 by creating the reverse of it (00010000) and negating it.
     * Then, we perform an AND with num. This will clear the ith bit and leave the remainder unchanged.
     */
    int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    /**
     * if i = 3 this will create ..0001111
     * <p>
     * To clear all bits from the most significant bit through i (inclusive),
     * we create a mask with a 1 at the ith bit (1 << i).
     * Then, we subtract 1 from it, giving us a sequence of 0s followed by i 1s.
     * We then AND our number with this mask to leave just the last i bits
     */
    static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
//        int mask = ~(-1 >> i);
        return num & mask;
    }

    /**
     * if i = 3 this creates ..1111000
     * <p>
     * To clear all bits from i through 0 (inclusive),
     * we take a sequence of all ls (which is -1) and shift it left by i + 1 bits.
     * This gives us a sequence of 1s (in the most significant bits) followed by i 0 bits.
     */
    static int clearBitsIThrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    /**
     * To set the ith bit to a value v, we first clear the bit at position i by using a mask that looks like 11101111.
     * Then, we shift the intended value,v, left by i bits. This will create a number with bit i equal tov and
     * all other bits equal to 0. Finally, we OR these two numbers, updating the ith bit ifv is 1 and leaving it as 0 otherwise.
     */
    int updateBit(int num, int i, boolean bitisl) {
        int value = bitisl ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    /* Returns 1 if a is positive, and 0 if a is negative */
    public static int sign(int a) {
        return 1^ ((a >> 31) & 0x1);
    }
    private static int getSign(int a) {
        return (a >>> 31) ^ 1;
    }
}
