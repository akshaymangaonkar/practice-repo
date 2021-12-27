package sorter.util;

public class Utils {

    public static void swap(int index1, int index2, int[] arr){
        /**
         * n1=2 n2=3
         * n1=n1+n2=2+3=5
         * n2=n1-n2=5-3=2
         * n1=n1-n2=5-2=3
         */
        arr[index1] = arr[index1] + arr[index2];
        arr[index2] = arr[index1] - arr[index2];
        arr[index1] = arr[index1] - arr[index2];
    }
}
