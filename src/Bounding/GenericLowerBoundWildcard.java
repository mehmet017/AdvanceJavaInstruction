package Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundWildcard {

    public static void main(String[] args) {
        System.out.println("-----------wildcard ile alt sinir----------------");
        List<Integer> integerList =new ArrayList<>();
        addElements(integerList);
        System.out.println(integerList);

        List<Number> numberList = new ArrayList<>();
        addElements(numberList);
        System.out.println(numberList);

        List<Double> doubleList = new ArrayList<>();
        //addElements(doubleList); CTE : Integer'in parent'larini kabul eder.

        System.out.println("-----------wildcard ile ust sinir----------------");
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        multiplyByTwo(numberList);

        System.out.println("-------------? vs Object -------------");
        List<String> stringList= new ArrayList<>();
        printElements(integerList);
        printElements(stringList);
        //--------------print object------------
        List<Object> objectList = new ArrayList<>();
        printElementsObject(objectList);
        printElementsObject(stringList);
        
        
    }

    private static void printElementsObject(List<Object> objectList) {
    }

    //Integer data tipinin super classlari ile olusturulan liste eleman ekleyen method
    //Integer, Number, Object
    //wildcard: ?: bilinmeyen data tipi
    public static void addElements(List<? super Integer> list){


        for (int i=1; i<=10;i++){
            list.add(i);
        }



    }

    //upperbound'da wildcard kullanimi
    public static void multiplyByTwo(List<? extends Number> list){

        //list.add(1);--> listte degisiklige izin vermez
        list.stream().map(t-> 2* t.doubleValue()).forEach(System.out::println);

    }

    //wildcard kısıtlaması
    public static void printElements(List<?> listOfUnknown){

        //listOfUnknown.add("Java");--> tur bilinmedigi icin izin vermiyor
        //add methodu gibi islemlere izin vermez
        //okumaya izin verir. salt-okur degil ama boyle dusunulebilir
        //turden bagimsiz islemlere izin verir. size, clear, remove...
        //listOfUnknown.size();

        //listOfUnknown.add(null);--> null: data tipi olmadigindan izin verir
        for (Object object:listOfUnknown){
            System.out.println(object);
        }
    }



}
