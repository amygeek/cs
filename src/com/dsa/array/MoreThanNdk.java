package com.dsa.array;
/*
Find All Elements in an Array which appears more than N/K times, N is Array Size and k is a Number.
int[] arrA = { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };

K = 4

N/k = 14/4 = 3

Output will be [3,4] they appear 5, 4 times respectively.
Naive Approach: Take two for loops , check every element with all other elements, Time Complexity -   O(n2) time.

Better Approach: Tetris Game technique– O(Nk)
Create array etms[] contains k-1 objects of class Elements with element =0 and count = 0.
So idea is, navigate all the elements of given array.
Check if element exist in etms[] if not, insert it with the count 1 and if exist then increase its count.
Also check if etms[] gets full when inserting an element, if it is not, follow the previous step. If it is full then reduce the count of every existing element in the etms[]. (Just think of a Tetris game, when row gets full, it gets deleted and size of the Tetris reduced by 1) see the picture below.
Once all the elements of array gets over, check every element of etms[] with array and print those elements which has N/K times.
 */
class Elements {
    int element;
    int count;

    public Elements(int element, int count) {
        this.element = element;
        this.count = count;
    }
}

//Objective is to find the element in an array
///which occurs more than n/k times
public class MoreThanNdk {

    public void findElement(int[] arrA, int k) {

        Elements[] elm = new Elements[k - 1];

        for (int j = 0; j < elm.length; j++) {
            elm[j] = new Elements(0, 0);
        }

        for (int i = 0; i < arrA.length; i++) {
            int index = found(elm, arrA[i]);
            if (index >= 0) {
                // means element found in Elements array
                // just increase its count
                elm[index].count++;
            } else {
                addtoArray(elm, arrA[i]);
            }
        }//
        // now check if any of the elements in the Elements array appears
        // more than n/k times
        for (int i = 0; i < elm.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arrA.length; j++) {
                if (arrA[j] == elm[i].element) {
                    cnt++;
                }
            }
            if (cnt > (arrA.length / k)) {
                System.out.println(elm[i].element + " appears more than n/"
                        + k + " times, Actual count is " + cnt);
            }
        }
    }

    public void addtoArray(Elements[] elm, int x) {
        // check is array is full or not
        for (int j = 0; j < elm.length; j++) {
            if (elm[j].count == 0) {// find the empty place and add it
                elm[j].element = x;
                return;
            }
        }
        // if we have reached here means array is full
        // reduce the counter of every element
        for (int j = 0; j < elm.length; j++) {
            elm[j].count--;
        }
    }

    // This found function will check whether element already exist or not
    // if yes then return its index else return -1
    public int found(Elements[] elm, int x) {
        for (int j = 0; j < elm.length; j++) {
            if (elm[j].element == x) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arrA = { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };
        MoreThanNdk n = new MoreThanNdk();
        n.findElement(arrA, 4);
    }
}

