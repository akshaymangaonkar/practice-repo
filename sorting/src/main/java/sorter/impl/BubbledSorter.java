package sorter.impl;

import sorter.Sorter;
import sorter.util.Utils;

public class BubbledSorter implements Sorter {

    /**
     * elements = [8,6,1,22,5]
     */
    @Override
    public void sort(int[] elements) {
        boolean flag = true;
        int len = elements.length;
        while(flag){
            flag = false;
            int i=0;
            int j=i+1;
            while(i < len-1){
                if(elements[i] > elements[j]){
                    Utils.swap(i, j, elements);
                    flag = true;
                }
                i++;j++;
            }
        }
    }

    @Override
    public void sortRecursively(int[] elements, int size){
        for(int i=0;i<size-1;i++){
            if(elements[i] > elements[i+1]){
                Utils.swap(i, i+1, elements);
            }
        }
        if(size-1 > 1){
            sortRecursively(elements, size-1);
        }
    }
}
