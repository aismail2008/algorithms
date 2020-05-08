package com.code.test.problemset.companies.Pramp;

/**
 * Validate IP Address
 * Validate an IP address (IPv4). An address is valid if and only if it is in the form "X.X.X.X", where each X is a number from 0 to 255.
 *
 * For example, "12.34.5.6", "0.23.25.0", and "255.255.255.255" are valid IP addresses, while "12.34.56.oops", "1.2.3.4.5", and "123.235.153.425" are invalid IP addresses.
 *
 * Examples:
 *
 * ip = '192.168.0.1'
 * output: true
 *
 * ip = '0.0.0.0'
 * output: true
 *
 * ip = '123.24.59.99'
 * output: true
 *
 * ip = '192.168.123.456'
 * output: false
 * Constraints:
 *
 * [time limit] 5000ms
 * [input] string ip
 * [output] boolean
 *
 *
 * Time Complexity: O(N), where N is the number of characters in ip. Our split operation takes O(N) time, and our fitsOneByte operation takes a linear amount of time for each chunk, and the sum of the chunks is the whole string.
 *
 * Space Complexity: O(N), the space used when considering each part of the original string ip.
 */
public class ValidateIpAddress {
    static boolean validateIP(String ip) {
        if(ip == null || ip.length() < 7 || ip.length() > 15){ // 1.1.1.1
            return false;
        }

        String[] parts = ip.split("\\.");
        if(parts.length != 4){
            return false;
        }

        for(int j = 0; j < 4; j++){
            try{
                System.out.println(parts[j]);
                int val = Integer.valueOf(parts[j]);
                if(val < 0 || val > 255){
                    return false;
                }
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validateIP("192.168.0.1");
    }
}
