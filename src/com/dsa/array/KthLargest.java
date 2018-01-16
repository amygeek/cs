package com.dsa.array;

/*
1) Build a Min Heap of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of min heap.
If the element is greater than the root then make it root and call heapify for min heap.
else ignore it. The step 2 is O((n-k)*logk)
3) Finally, min heap has k largest elements and root of the min heap is the kth largest element.

Time Complexity: O(k + (n-k)Logk) without sorted output. If sorted output is needed then O(k + (n-k)Logk + kLogk)

All of the above methods can be used to find the kth largest (or smallest) element.
 */
public class KthLargest {

    void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    void minHeapify(int a[], int size, int i) {
        int l = 2 * i;
        int r = 2 * i + 1;
        int smallest = i;
        if(l<size && a[l]<a[smallest])
            smallest = l;
        if(r<size && a[r]<a[smallest])
            smallest = r;
        if(smallest!=i)
        {
            swap(a[i], a[smallest]);
            minHeapify(a,size,smallest);
        }

    }


    void buildMinHeap(int a[], int size) {
        for(int i=size/2;i>=0;i--)
            minHeapify(a,size,i);

    }


    int findKthLargest(int a[], int size, int k)
    {
        int[] minHeap = new int[k];
        int i;
        for(i=0;i<k;i++)
            minHeap[i] = a[i];
        buildMinHeap(minHeap,k);
        for(i=k;i<size;i++)
        {
            if(a[i]>minHeap[0])
            {
                minHeap[0]=a[i];
                minHeapify(minHeap,k,0);
            }
        }
        return minHeap[0];
    }


    public static void main( String[] args) {

        KthLargest kthLargest = new KthLargest();
        int a[] = {16,17,18,4,12,9,5,1};
        //int size = sizeof(a)/sizeof(a[0]);
        int size = a.length;
        int k = 3;

        System.out.println(kthLargest.findKthLargest(a, size, k));
    }
}



        
