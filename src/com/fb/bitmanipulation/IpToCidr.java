package com.fb.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * HireVue JPMC
 *
 * Given a start IP address ip and a number of ips we need to cover n, return a representation of
 * the range as a list (of smallest possible length) of CIDR blocks.
 *
 * <p>A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length.
 * For example: "123.45.67.89/20". That prefix length "20" represents the number of common prefix
 * bits in the specified range.
 *
 * <p>Example 1: Input: ip = "255.0.0.7", n = 10 Output:
 * ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"] Explanation: The initial ip address, when
 * converted to binary, looks like this (spaces added for clarity): 255.0.0.7 -> 11111111 00000000
 * 00000000 00000111 The address "255.0.0.7/32" specifies all addresses with a common prefix of 32
 * bits to the given address, ie. just this one address.
 *
 * <p>The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the
 * given address: 255.0.0.8 -> 11111111 00000000 00000000 00001000 Addresses with common prefix of
 * 29 bits are: 11111111 00000000 00000000 00001000 11111111 00000000 00000000 00001001 11111111
 * 00000000 00000000 00001010 11111111 00000000 00000000 00001011 11111111 00000000 00000000
 * 00001100 11111111 00000000 00000000 00001101 11111111 00000000 00000000 00001110 11111111
 * 00000000 00000000 00001111
 *
 * <p>The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the
 * given address, ie. just 11111111 00000000 00000000 00010000.
 *
 * <p>In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .
 *
 * <p>There were other representations, such as: ["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30",
 * "255.0.0.16/32"], but our answer was the shortest possible.
 *
 * <p>Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect, because
 * it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100 that are outside the
 * specified range.
 *
 * @author swamy on 3/13/21
 */
public class IpToCidr {
  public static void main(String[] args) {
      IpToCidr i = new IpToCidr();
//Input: ip = "255.0.0.7", n = 10
//Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]

      //192.168.0.0/18
      //out:192.168.16.1
      List<String> res = i.ipToCIDR("192.168.0.0", 18);
      res.forEach(System.out::println);
  }

    public List<String> ipToCIDR(String ip, long n) {
        long x = 0;
        String[] parts = ip.split("\\."); // we need \\ here because '.' is a keyword in regex.
        for(int i = 0; i < 4; i++) {
            x = x * 256 + Long.parseLong(parts[i]);
        }

        List<String> res = new ArrayList();
        while(n > 0) {
            //handle 0.0.0.0/32
            if (x == 0) {
                res.add("0.0.0.0/32");
                n--;
                x++;
                continue;
            }

            long count = x & -x;
            // this count value here means if we don't change the current start ip, how many
            // more ips we can represent with CIDR

            while(count > n) { // incase the count(mask) is too larget. For example count is 7 but we only need 2 more ips
                count >>= 1;//count /= 2;
            }

            res.add(oneCIDR(x, count));
            n = n - count;
            x = x + count;
        }
        return res;
    }

    private String oneCIDR(long x, long count) {
        long d, c, b, a;
        d =  x & 255; // Compute right-most part of ip
        x >>= 8; // throw away the right-most part of ip
        c =  x & 255;
        x >>= 8;
        b =  x & 255;
        x >>= 8;
        a =  x & 255;

        int len = 0;
        // this while loop to know how many digits of count is in binary
        // for example, 00001000 here the len will be 4.
        while(count > 0) {
            count>>=1;//count /= 2;
            len++;
        }
        int mask = 32 - (len - 1);
        // Think about 255.0.0.7 -> 11111111 00000000 00000000 00000111
        // x & -x of it is 00000001, the mask is 32. (which is 32 - (1 - 1))

        return new StringBuilder()
                .append(a)
                .append(".")
                .append(b)
                .append(".")
                .append(c)
                .append(".")
                .append(d)
                .append("/")
                .append(mask)
                .toString();
    }
}

