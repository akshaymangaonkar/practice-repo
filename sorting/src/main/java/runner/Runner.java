package runner;
import sorter.impl.BubbledSorter;

public class Runner {


    public static void main(String[] args) {
		BubbledSorter s = new BubbledSorter();
        int[] input = new int[]{33,552,22,51,1,-2,6};
        logArray(input);
        long before = System.currentTimeMillis();
		s.sort(input);
//        s.sortRecursively(input);
        long after = System.currentTimeMillis();
        logArray(input);
        System.out.println("Sorted Array in " + (after - before) + " ms.");
    }

    private static void logArray(int[] input){
        StringBuilder sb = new StringBuilder();
        for(int x=0; x< input.length; x++){
            sb.append(input[x]);
            if(!(input.length-x==1))
                sb.append(",");
        }
        System.out.println("Array: " + sb.toString());
    }

}
