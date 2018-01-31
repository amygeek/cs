package com.dsa.array;

/*
Find median of two sorted arrays of same size
Given two sorted arrays of size n. Write an algorithm to find the median of combined array (merger of both the given arrays, size = 2n).
 Say arrays are array1[] and array2[].
Calculate the median of both the arrays, say m1 and m2 for array1[] and array2[].
If m1 == m2 then return m1 or m2 as final result.
If m1 > m2 then median will be present in either of the sub arrays.
Array1[] – from first element to m1.
Array2[] – from m2 to last element.
If m2 > m1 then median will be present in either of the sub arrays.
Array1[] – from m1 to last element.
Array2[] – from first element to m2.
Repeat the steps from 1 to 5 recursively until 2 elements are left in both the arrays.
Then apply the formula to get the median
Median = (max(array1[0],array2[0]) + min(array1[1],array2[1]))/2

int [] a = {2,6,9,10,11};
int [] b = {1,5,7,12,15};

m1 = 9 , m2 = 7
We have m1 > m2
Array1[] - from first element to m1, Array2[] – from m2 to last element.

int [] a = {2,6,9};
int [] b = {7,12,15};

We have m1 < m2
Array1[] - from m1 to last element, Array2[] – from first element to m2.

int [] a = {6,9};
int [] b = {7,12};
Now we have 2 elements left in both the arrays so now apply the formula

Median = (max(array[0],array[0]) + min(array[1],array[1]))/2
=(max(6,7) + min(9,12))/2
= (7+9)/2
=8
O(logn)
 */
public class MedianBinary {

    public float find(int [] a, int startA, int endA, int [] b, int startB, int endB){

        if(endA - startA + 1 == 2 && endB - startB + 1 == 2){
            float x = Math.max(a[startA], b[startB]);
            float y = Math.min(a[endA],b[endB]);
            return ( x + y ) / 2;
        }

        float medianA = getMedian(a, startA, endA);
        float medianB = getMedian(b, startB, endB);

        int midA = ( startA + endA ) / 2;
        int midB = ( startB + endB ) / 2;
        if(medianA > medianB){
            return find(a, startA, midA, b, midB, endB);
        }else{
            return find(a, midA, endA, b, startB, midB);
        }

    }

    public float getMedian(int [] x, int start, int end){

        int size = end - start + 1;

        if(size % 2 == 0 ){
            float m = x[start + ( size / 2 )];
            float n = x[start + ( size - 1 ) / 2];
            return ( m + n ) / 2;
        }else{
            return  x[start + ( size - 1 ) / 2 ];
        }
    }

    public static void main(String[] args) {
        MedianBinary m = new MedianBinary();
        int [] a = {2,6,9,10,11};
        int [] b = {1,5,7,12,15};
        float x = m.find(a,0,a.length-1,b,0,b.length-1);
        System.out.println("Median of combined sorted array is: " + x);
    }
}
