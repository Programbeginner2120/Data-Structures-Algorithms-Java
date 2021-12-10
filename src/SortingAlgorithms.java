import java.util.Arrays;

class Sorting {

    public static int [] insertionSort(int [] arr){
        for (int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int j = i;
            while (j != 0 && arr[j - 1] > curr){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = curr;
        }
        return arr;
    }

    public static int [] merge(int [] left, int [] right){
        int i = 0;
        int j = 0;
        int idx = 0;
        int [] returnArray = new int [(left.length + right.length)];
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                returnArray[idx] = left[i];
                i++;
            }
            else{
                returnArray[idx] = right[j];
                j++;
            }
            idx++;
        }

        int [] arrayRemains = j < i ? right : left;
        int remainderIndex = j < i ? j : i;
        for (int k = remainderIndex; k < arrayRemains.length; k++){
            returnArray[idx] = arrayRemains[k];
            idx++;
        }

        return returnArray;
    }

    public static int [] mergeSort(int [] arr){
        if (arr.length <= 1)
            return  arr;

        int midpoint = arr.length / 2;
        int [] left = mergeSort(Arrays.copyOf(arr, midpoint));
        int [] right = mergeSort(Arrays.copyOfRange(arr, midpoint, arr.length));

        return merge(left, right);
    }

}

public class SortingAlgorithms {

    public static void main(String[] args){
        int [] myArray = {2, 1, 4,-3};

        int [] rv = Sorting.mergeSort(myArray);
        System.out.println(Arrays.toString(rv));

        rv = Sorting.insertionSort(myArray);
        System.out.println(Arrays.toString(rv));
    }

}
