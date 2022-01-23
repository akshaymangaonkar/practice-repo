package sorter.impl;

import sorter.Pivot;
import sorter.PivotSorter;
import sorter.util.Utils;


public class QuickSorter extends PivotSorter {


    public QuickSorter(Pivot p) {
        super(p);
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
        if(this.getPivot() == null){
            // default policy is to use last element as pivot
            this.setPivotPolicy( Pivot.LAST);
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
        int ppos=-1;
        switch (this.getPivot()){
            case FIRST:
                ppos=low;
                for(int i=low+1; i<=high; i++){
                    if(elements[i] <= p){
                        if(i != ++ppos) {
                            Utils.swap(i, ppos, elements);
                        }
                    }
                }
                ppos--;
                if(++ppos != pIdx) {
                    Utils.swap(pIdx, ppos, elements);
                }
                break;
            case LAST:
                ppos=low -1;
                for(int i=low; i<high; i++){
                    if(elements[i] <= p){
                        if(i != ++ppos) {
                            Utils.swap(i, ppos, elements);
                        }
                    }
                }
                if(++ppos != pIdx) {
                    Utils.swap(pIdx, ppos, elements);
                }
                break;
            case RANDOM:
                ppos=pIdx;
                int lesser = 0;
                for(int i=low; i<=high; i++){
                    if(i != ppos){
                        if(elements[i] <= p){
                            lesser++;
                            if(i > ppos){
                               Utils.swap(i, ppos, elements);
                               ppos = i;
                                if(i>low+lesser) {
                                    for (int j = i; j > low+lesser; j--, ppos--) {
                                        Utils.swap(j, j - 1, elements);
                                    }
                                }
                            }
                        }
                        else if(elements[i] >= p){
                            if(i != high){
                                if(i < ppos) {
                                    Utils.swap(i, ppos, elements);
                                    ppos = i;
                                }
                            }

                        }
                    }
                }
                break;
        }
        return ppos;
    }
}
