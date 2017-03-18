package com.dsa.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Data implements Comparable<Data>
{
    int value, count, index;

    public Data(int value, int count, int index)
    {
        this.value = value;
        this.count = count;
        this.index = index;
    }

    public int compareTo(Data obj)
    {
        // If two elements have the different frequencies, then
        // the one which has more frequency should come first
        if (this.count != obj.count)
            return obj.count - this.count;

        // If two elements have the same frequencies, then the
        // one which has less index should come first
        return this.index - obj.index;
    }

    public String toString()
    {
        return value + " " + count + " " + index;
    }
}

class CustomSort
{
    // Custom sort by element's frequency and index
    public void customSort(int arr[])
    {
        if (arr == null || arr.length < 2)
            return;

        Map<Integer, Data> hm = new HashMap<Integer, Data>();
        Data data = null;

        // for each element of the array, insert into map its frequency
        // and index of its first occurrence in the array
        for (int i = 0; i < arr.length; i++)
        {
            data = hm.get(arr[i]);
            // element is seen for the first time
            if (data == null)
                hm.put(arr[i], new Data(arr[i], 1, i));
            else
                // element is seen before
                data.count++;
        }

        // sort the values based on custom comparator
        Object[] values = hm.values().toArray();
        Arrays.sort(values);

        int k = 0;
        for (int i = 0; i < values.length; i++)
        {
            data = (Data)values[i];
            for (int j = 0; j < data.count; j++)
                arr[k++] = data.value;
        }
    }

    public static void main(String[] args)
    {
        int arr[] = { 3, 3, 1, 1, 1, 8, 3, 6, 8, 7, 8 };

        new CustomSort().customSort(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}