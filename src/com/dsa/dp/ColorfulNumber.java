package com.dsa.dp;


import java.util.HashSet;
import java.util.Set;

/*
For Given Number N find if its COLORFUL number or not

Return true or false

COLORFUL number:

A number can be broken into different subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a subsequence are different

Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different.

Colorful Number: When in a given number, product of every digit of a sub-sequence are different.

Example:

Given Number : 3245
Output : Colorful
Number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
this number is a colorful number, since product of every digit of a sub-sequence are different.
That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20, (3*2*4)= 24 (2*4*5)= 40

Given Number : 326
Output : Not Colorful.
326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
 */
public class ColorfulNumber {

    public boolean isColorFull (int a) {

        String s = String.valueOf(a);

        Set<Integer> set = new HashSet<>();

        int temp = 0;

        while (temp < s.length()) {
            //if consecutive Integer is same return 0
            if (set.contains(s.charAt(temp) - '0')) {
                return false;
            }
            set.add(s.charAt(temp) - '0');
            temp++;
        }

        int i = 0;
        int j = 1;
        int n = s.length();

        int val1 = 0;
        int val2 = 0;

        while (j < n) {

            val1 = s.charAt(i) - '0';
            val2 = s.charAt(j) - '0';

            if (set.contains(val1*val2))
                return false;

            set.add(val1 * val2);

            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        ColorfulNumber colorfulNumber = new ColorfulNumber();
        System.out.println(colorfulNumber.isColorFull(234));    // true
        System.out.println(colorfulNumber.isColorFull(2347));   // true
        System.out.println(colorfulNumber.isColorFull(123));    // false
        System.out.println(colorfulNumber.isColorFull(62345));  // false
        System.out.println(colorfulNumber.isColorFull(23));     // true
        System.out.println(colorfulNumber.isColorFull(3245));   // true
        System.out.println(colorfulNumber.isColorFull(326));    // false
    }

}