package sorter.impl;

import sorter.Pivot;
import sorter.Sorter;

import java.util.Random;

public class MergeSorter implements Sorter {

    private final Pivot pivot = Pivot.MEDIAN;

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
                pivotIndex = (high+1 - low)/2;
                break;
        }
        return pivotIndex;
    }

    @Override
    public void sort(int[] elements) {
        sortRecursively(elements, elements.length);
    }

    @Override
    public void sortRecursively(int[] elements, int size) {
        int high = size-1;
        int low = 0;
        sort(elements, low, high);
    }

    private void sort(int[] elements, int low, int high){
        if(elements.length == 1){
            return;
        }
        int pIdx = this.getPivotIndex(low, high);
        int lowerArrSize = pIdx;
        int upperArrSize = elements.length - pIdx;
        int[] lowerArr = populateArrays(elements, 0, lowerArrSize);
        int[] upperArr = populateArrays(elements, pIdx, upperArrSize);

        sort(lowerArr, 0, pIdx - 1);
        sort(upperArr, pIdx, elements.length-1);

        merge(elements, lowerArr, upperArr);
    }

    private int[] populateArrays(int[] source, int low, int size){
        int[] arr = new int[size];
        for(int i=low, j=0; j<size; i++, j++){
            arr[j] = source[i];
        }
        return arr;
    }

    private void merge(int[] source, int[] l, int[] u){
        int i = 0, j = 0, k = 0;

        for(; i<l.length && j<u.length;){
            if(l[i] < u[j]){
                source[k++] = l[i++];
            }else{
                source[k++] = u[j++];
            }
        }
        for(; i<l.length ;){
            source[k++]=l[i++];
        }
        for(; j<u.length ;){
            source[k++]=u[j++];
        }
    }
}
