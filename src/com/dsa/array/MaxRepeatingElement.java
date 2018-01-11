package com.dsa.array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxRepeatingElement {

    //Time Complexity : O(n) and Space Complexity: O(n).
    public void maxRepeatingElementUsingMap(int [] arrA){
        //Will store each character and it's count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arrA.length; i++) {
            if(map.containsKey(arrA[i])){
                map.put(arrA[i],map.get(arrA[i])+1);
            }else{
                map.put(arrA[i], 1);
            }
        }

        //traverse the map and track the element which has max count
        Iterator entries = map.entrySet().iterator();
        int maxCount = 0;
        int element =arrA[0];
        while(entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            int count = (Integer)entry.getValue();
            if(maxCount<count){
                maxCount = count;
                element = (Integer)entry.getKey();
            }
        }
        System.out.println("Element repeating maximum no of times: " + element + ", maximum count: " + maxCount);
    }
    /*
    O(n) time and O(1) extra space.

    This solution works only if array has positive integers and all the elements in the array are in range from 0 to n-1 where n is the size of the array.
    Navigate the array.
    Update the array as for ith index :- arrA[arrA[i]% n] = arrA[arrA[i]% n] + n;
    Now navigate the updated array and check which index has the maximum value, that index number is the element which has the maximum occurrence in the array.
     */
    public void MaxRepeatingElementInPlace(int [] arrA){
        int size = arrA.length;
        int maxCount=0;
        int maxIndex=0;
        for (int i = 0; i <size ; i++) {
            //get the index to be updated
            int index = arrA[i]% size;
            arrA[index] = arrA[index] + size;
        }
        for (int i = 0; i <size ; i++) {
            if(arrA[i]/size>maxCount){
                maxCount=arrA[i]/size;
                maxIndex=i;
            }
        }
        System.out.println("Element repeating maximum no of times: " + maxIndex + ", maximum count: " + maxCount);
    }
    public static void main(String[] args) {
        int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        MaxRepeatingElement m = new MaxRepeatingElement();
        m.MaxRepeatingElementInPlace(arrA);
    }
}
