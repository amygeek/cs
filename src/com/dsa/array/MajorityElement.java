package com.dsa.array;

import java.util.List;
import java.util.ArrayList;

/* Program for finding out majority element in an array */
public class MajorityElement {


    void printMajority(int a[], int size) {
    /* Find the candidate for Majority*/
        int candidate = findCandidate(a, size);

    /* Print the candidate if it is Majority*/
        if (isMajority(a, size, candidate))
            System.out.println(" " + candidate + " ");
        else
            System.out.println("No Majority Element");
    }

    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int candidate) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == candidate)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }

    public int majorityEle (final List<Integer> a) {
        int len = a.size();

        if(a.size() == 0) {
            return -1;
        }

        if(a.size() == 1) {
            return a.get(0);
        }

        int c1 = a.get(0);
        int c2 = a.get(1);
        int c1count = 0;
        int c2count = 0;

        for(int num : a) {
            if(c1 == num) {
                c1count++;
            } else if(c2 == num) {
                c2count++;
            } else if(c1count == 0) {
                c1 = num;
                c1count = 1;
            } else if(c2count == 0) {
                c2 = num;
                c2count = 1;
            } else {
                c1count--;
                c2count--;
            }
        }

        c1count = 0;
        c2count = 0;
        for(int num : a) {
            if(c1 == num) {
                c1count++;
            } else if(num == c2) {
                c2count++;
            }
        }

        if(c1count > len / 3) {
            return c1;
        } else if(c2count > len / 3) {
            return c2;
        } else {
            return -1;
        }

    }
    
    /* Driver program to test the above functions */
    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();

        List ls = new ArrayList();  //1, 3, 3, 3, 3, 1, 2
        ls.add(1);
        ls.add(3);
        ls.add(3);
        ls.add(3);
        ls.add(3);
        ls.add(1);
        ls.add(2);
        int a[] = new int[]{1, 3, 3, 3, 3, 1, 2};  //none
        //int a[] = new int[]{2, 2, 3, 5, 2, 2, 6};  //2

        int num = element.majorityEle(ls);
        System.out.println(num);
    }

}
