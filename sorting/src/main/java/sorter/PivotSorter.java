package sorter;

import java.util.Random;

public abstract class PivotSorter implements Sorter{

    private Pivot pivot;

    public PivotSorter(Pivot p){
        this.pivot = p;
    }

    protected int getPivotIndex(int low, int high){
        int pivotIndex=0;
        switch (this.pivot){
            case FIRST:
                pivotIndex = low;
                break;
            case LAST:
                pivotIndex = high;
                break;
            case RANDOM:
                int r = new Random().nextInt(high+1);
                pivotIndex =  r==0?r+low:r;
                break;
            case MEDIAN:
                pivotIndex = (high+1 - low)/2;
                break;
        }
        return pivotIndex;
    }

    public void setPivotPolicy(Pivot pivot){
        this.pivot = pivot;
    }

    protected Pivot getPivot(){
        return this.pivot;
    }

}
