package sorter.impl;

import sorter.Pivot;
import sorter.Sorter;
import sorter.util.Utils;

import java.util.Random;

public class QuickSorter implements Sorter {

    private Pivot pivot;

    private int getPivotIndex(int low, int high){
        int pivotIndex=0;
        switch (this.pivot){
            case FIRST:
                pivotIndex = 0;
                break;
            case LAST:
                pivotIndex = high;
                break;
            case RANDOM:
                pivotIndex = new Random(low).nextInt(high);
                break;
            case MEDIAN:
                pivotIndex = (high-low)/2;
                break;
        }
        return pivotIndex;
    }

    public void setPivotPolicy(Pivot pivot){
        this.pivot = pivot;
    }


    /**
     * The goal with quick sort is to find the correct position of the pivot in our input array
     * Once found all elements to the left and right need to be treated as sub arrays and processed
     *  the same was os our main array with their respective pivots
     * @param elements
     */
    @Override
    public void sort(int[] elements) {
        sortRecursively(elements, elements.length);
    }

    @Override
    public void sortRecursively(int[] elements, int size) {
        if(elements.length == 1){
            return;
        }
        if(this.pivot == null){
            // default policy is to use last element as pivot
            this.pivot = Pivot.LAST;
        }
        int high = elements.length-1;
        int low = 0;
        sort(elements,low, high);
    }

    private void sort(int[] elements, int low, int high){
        if(high > low){
            int ptn = this.partition(elements, low, high);
            sort(elements, low, ptn-1);
            sort(elements, ptn+1, high);
        }
    }

    private int partition(int[] elements, int low, int high){
        int pIdx = this.getPivotIndex(low, high);
        int p = elements[pIdx];
        int ppos=low -1;
        for(int i=low; i<high; i++){
            if(elements[i] < p){
                if(i != ++ppos) {
                    Utils.swap(i, ppos, elements);
                }
            }
        }
        if(++ppos != pIdx) {
            Utils.swap(pIdx, ppos, elements);
        }
        return ppos;
    }
}
