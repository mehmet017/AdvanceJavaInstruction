package Generics.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr = {1, 23, 4, 65, 9};
        Double[] doubleArr = {0.5, 2.3, 45.9, 11.75};
        String[] strArr = {"Java", "harika", "bir", "programlama", "dili:)"};

        printArr(intArr);
    }
    //arrayleri yazdirmak icin method
    public static void printArr(Integer[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));

    }

}
