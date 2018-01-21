package com.dsa.array;

import java.util.Arrays;

/** All elements appears three times and one element appears once. Find that element in O(n) time…

 O(n) time and O(1) space:

 1) Sum all the bits in same positions for all the elements and take modulus with 3.
 2) If remainder is 0 i.e if sum is multiple of 3 means that bit is set by elements appear­ing thrice.
 3) If remainder is not 0 i.e sum is not multiple of 3, it means that bit is set in element appears once for sure.
 (not sure if that bit is set or unset in elements appearing thrice.)
 4) So if we repeat step 1,2,3 for all the elements for all the positions then we will get the element appearing once. See the exam­ple below

 Say arr[] = {6, 6, 6, 3}

 1 1 0
 1 1 0
 1 1 0
 0 1 1
 __________+
 3 4 1

 Now modulus with 3

 3mod3  4mod3 1mod3 => 0 1 1 => 3 element appearing once.
 */
public class MissNumber {
    public static void find (int [] arr){
        int singleElement =0;
        for (int i = 0; i <32 ; i++) { //this is for calculating for every position in 32 bit integer
            int y = ( 1 << i);
            int count = 0;
            for (int j = 0; j <arr.length ; j++) {
                if( ( arr[j] & y ) >= 1) //if that particular bit is set for the ith position, add 1 to count (w.r.t that bit)
                    count = count +1;
            }
            //if bits are not multiple of 3 then that bit belongs to the element appearing single time
            if( ( count % 3 ) == 1 ) {

                singleElement = singleElement | y;

            }
        }
        System.out.println("Element appearing once is: " + singleElement);
    }

    public static void main(String[] args) {
        int arr [] = {1, 4, 5, 6, 1, 4, 6, 1, 4, 6};
        System.out.println(Arrays.toString(arr));
        find(arr);
    }
}
