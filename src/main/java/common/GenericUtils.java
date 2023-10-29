package common;

public class GenericUtils<T> {;
    public void swap(T [] arr, int index1, int index2){
        if(index1 >= arr.length || index2 >= arr.length) return;
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void printArray (T [] arr){
        for(T i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
